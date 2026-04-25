package com.fitnesstrackerapp.enterprise;

import com.fitnesstrackerapp.enterprise.dto.Account;
import com.fitnesstrackerapp.enterprise.dto.DistanceGoal;
import com.fitnesstrackerapp.enterprise.dto.Goal;
import com.fitnesstrackerapp.enterprise.dto.RepGoal;
import com.fitnesstrackerapp.enterprise.service.IAccountService;
import com.fitnesstrackerapp.enterprise.service.IGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.io.IOException;

@SessionAttributes("account")
@Controller
public class FitnessAppController {
    private static final String DEFAULT_ACCOUNT_NAME = "Fred";
    private static final String DEFAULT_EMAIL = "Fred@email";
    private static final String DEFAULT_PASSWORD = "password";
    /**
     * Handle the root (/) endpoint and return a start page @return (currently no start page)
     *
     */
    @Autowired
    IGoalService goalService;

    @Autowired
    IAccountService accountService;

    @RequestMapping("/start")
    public String index(Model model, @SessionAttribute("account") Account account) throws Exception {

        List<Goal> goals = goalService.InProgress(account.getAccountId());
        model.addAttribute("goals", goals);

        //List<Goal> goals = goalService.fetchActiveGoals(account.getAccountId());

        return "start";
    }

    @RequestMapping("/saveGoal")
    public String saveGoal(Goal goal){
        try {
            goalService.save(goal);
        }
        catch (Exception e){
            e.printStackTrace();
            return "start";
        }

        return "start";
    }

    @GetMapping("/viewGoal")
    public String viewGoalPage(@RequestParam("goalId") int goalId, Model model) throws Exception {
        Goal goal = goalService.fetchById(goalId);
        model.addAttribute("goal", goal);
        return "viewGoal";
    }

    @GetMapping("/Goals")
    @ResponseBody
    public List<Goal> fetchAllGoals() throws Exception {return goalService.fetchAll();}


    @GetMapping("/viewGoal/{id}")
    public ResponseEntity<Goal> viewGoalPage(@PathVariable("id") int id) {
        try {
            Goal selectedGoal = goalService.fetchById(id);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            return new ResponseEntity<>(selectedGoal, headers, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateGoal")
    public String updateGoal(@ModelAttribute Goal goal) {
        try {
            goalService.update(goal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "start";
    }

    @GetMapping("/deleteGoal/{id}")
    public String deleteGoal(@PathVariable int id) {
        try {
            goalService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "start";
    }
    //Created Page map for the UI
    @GetMapping("/createGoal")
    public String createGoalPage() {
        return "createGoal";
    }

    @GetMapping("/account")
    public String accountPage(Model model) {
        return "account";
    }

    @GetMapping("/")
    public String loginPage(Model model) {
        model.addAttribute("account", new Account());
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("account", new Account());
        return "register";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute Account account, Model model) throws Exception {
        Account existing = accountService.fetchByEmail(account.getEmail());

        if (existing == null || !existing.getPassword().equals(account.getPassword())) {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }

        model.addAttribute("account", existing); // stored in session

        return "redirect:/start";
    }


    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute Account account, Model model) throws Exception {
        Account existing = accountService.fetchByEmail(account.getEmail());

        if (existing != null) {
            model.addAttribute("error", "Email already exists");
            return "register";
        }

        accountService.save(account);

        return "redirect:/";
    }

    @PostMapping("/updateAccount")
    public String updateAccount(
            @RequestParam int accountId,
            @RequestParam String accountName,
            @RequestParam String email,
            @RequestParam(required = false) String password,
            @SessionAttribute("account") Account sessionAccount,
            Model model
    ) throws Exception {

        Account account = accountService.fetchById(accountId);

        account.setAccountName(accountName);
        account.setEmail(email);

        // Only update password if user typed one
        if (password != null && !password.isBlank()) {
            account.setPassword(password);
        }

        accountService.update(account);

        // Update session so navbar + pages show new info
        model.addAttribute("account", account);

        return "redirect:/account";
    }

    @PostMapping("/createGoal")
    public String createGoalSubmit(
            @RequestParam String goalType,
            @RequestParam String goalName,
            @RequestParam double targetAmount,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date completionDate,
            @SessionAttribute("account") Account account
    ) throws Exception {

        Goal goal;

        if (goalType.equals("distance")) {
            DistanceGoal g = new DistanceGoal();
            g.setDistanceToComplete(targetAmount);
            g.setDistanceCompleted((double) 0);
            goal = g;
        } else {
            RepGoal g = new RepGoal();
            g.setRepsToComplete(targetAmount);
            g.setRepsCompleted((double) 0);
            goal = g;
        }

        goal.setGoalName(goalName);
        goal.setCompletionDate(completionDate);
        goal.setIsCompleted(false);
        goal.setAccountId(account.getAccountId());
        goalService.save(goal);

        return "redirect:/start";
    }

    @PostMapping("/updateGoalProgress")
    public String updateGoalProgress(
            @RequestParam int goalId,
            @RequestParam double progress
    ) throws Exception {

        Goal goal = goalService.fetchById(goalId);

        if (goal instanceof DistanceGoal) {
            ((DistanceGoal) goal).setDistanceCompleted(progress);
        } else if (goal instanceof RepGoal) {
            ((RepGoal) goal).setRepsCompleted((double) progress);
        }

        goalService.update(goal);

        return "redirect:/viewGoal?goalId=" + goalId;
    }

    @PostMapping("/completeGoal")
    public String completeGoal(@RequestParam int goalId) throws Exception {
        Goal goal = goalService.fetchById(goalId);
        goal.setIsCompleted(true);
        goalService.update(goal);

        return "redirect:/viewGoal?goalId=" + goalId;
    }



    @GetMapping("/allGoal")
    public String allGoalPage(Model model, @SessionAttribute("account") Account account) throws Exception {

        List<Goal> activeGoals = goalService.AllComplete(account.getAccountId());
        List<Goal> completedGoals = goalService.InProgress(account.getAccountId());

        model.addAttribute("activeGoals", activeGoals);
        model.addAttribute("completedGoals", completedGoals);
        return "allGoal";
    }


}

