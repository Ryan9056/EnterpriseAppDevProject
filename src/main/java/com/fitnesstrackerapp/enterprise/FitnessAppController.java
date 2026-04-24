package com.fitnesstrackerapp.enterprise;

import com.fitnesstrackerapp.enterprise.dto.Account;
import com.fitnesstrackerapp.enterprise.dto.DistanceGoal;
import com.fitnesstrackerapp.enterprise.dto.Goal;
import com.fitnesstrackerapp.enterprise.dto.RepGoal;
import com.fitnesstrackerapp.enterprise.service.IAccountService;
import com.fitnesstrackerapp.enterprise.service.IGoalService;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.List;
import java.util.Map;
import java.io.IOException;

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

    @ModelAttribute("account")
    public Account addAccountToModel() {
        //Example data for now
        Account account = new Account();
        account.setAccountId(1);
        account.setAccountName(DEFAULT_ACCOUNT_NAME);
        account.setEmail(DEFAULT_EMAIL);
        account.setPassword(DEFAULT_PASSWORD);
        return account;
    }

    @RequestMapping("/")
    public String index(Model model) throws Exception {

        // gets fake data from FakeGoalService
        List<Goal> goals = goalService.fetchAll();
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

    @GetMapping("/allGoal")
    public String allGoalPage() throws Exception {

        List<Goal> activeGoals = goalService.fetchAll();
        return "allGoal";
    }


}

