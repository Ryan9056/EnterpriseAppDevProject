package com.fitnesstrackerapp.enterprise;

import com.fitnesstrackerapp.enterprise.dto.Account;
import com.fitnesstrackerapp.enterprise.dto.DistanceGoal;
import com.fitnesstrackerapp.enterprise.dto.Goal;
import com.fitnesstrackerapp.enterprise.dto.RepGoal;
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

    @RequestMapping("/")
    public String index(Model model){
        //Account Attributes For Ui
        //Example Data for now
        Account account = new Account();
        account.setAccountId(1);
        account.setAccountName(DEFAULT_ACCOUNT_NAME);
        account.setEmail(DEFAULT_EMAIL);
        account.setPassword(DEFAULT_PASSWORD);
        model.addAttribute("account", account);

        List<Goal> goals = new ArrayList<>();

        DistanceGoal dGoal = new DistanceGoal();
        dGoal.setGoalType("Miles");
        dGoal.setDistanceToComplete(5);
        dGoal.setDistanceCompleted(3);
        goals.add(dGoal);

        RepGoal repGoal = new RepGoal();
        repGoal.setGoalType("Sit Ups");
        repGoal.setRepsToComplete(50);
        repGoal.setRepsCompleted(32);
        goals.add(repGoal);

        //List<Goal> goals = goalService.fetchActiveGoals(account.getAccountId());
        model.addAttribute("goals", goals);

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
    public ResponseEntity viewGoalPage(@RequestParam(value="goal", required=true, defaultValue="None") int goalId) {
        Goal goal = goalService.fetchById(goalId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(goal, headers, HttpStatus.OK);
    }

    //Created Page map for the UI
    @GetMapping("/createGoal")
    public String createGoalPage() {
        return "createGoal";
    }

    @GetMapping("/account")
    public String accountPage() {
        return "account";
    }

    @GetMapping("/start")
    public String startPage() {
        return "start";
    }

    @GetMapping("/allGoal")
    public String allGoalPage() {
        return "allGoal";
    }



}

