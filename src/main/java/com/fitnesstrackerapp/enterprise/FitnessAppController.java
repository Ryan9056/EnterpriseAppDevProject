package com.fitnesstrackerapp.enterprise;

import com.fitnesstrackerapp.enterprise.dto.Account;
import com.fitnesstrackerapp.enterprise.dto.DistanceGoal;
import com.fitnesstrackerapp.enterprise.dto.RepGoal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class FitnessAppController {
    private static final String DEFAULT_ACCOUNT_NAME = "Fred";
    private static final String DEFAULT_EMAIL = "Fred@email";
    private static final String DEFAULT_PASSWORD = "password";
    /**
     * Handle the root (/) endpoint and return a start page @return (currently no start page)
     *
     */
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

        //Distance Goal Attributes For Ui
        //Example Data for now
        DistanceGoal dGoal = new DistanceGoal();
        dGoal.setGoalType("Miles");
        dGoal.setDistanceToComplete(5);
        dGoal.setDistanceCompleted(3);
        model.addAttribute("dGoal", dGoal);

        //Distance Goal Attribute For Ui
        //Example Data for now
        RepGoal repGoal = new RepGoal();
        repGoal.setGoalType("Sit Ups");
        repGoal.setRepsToComplete(50);
        repGoal.setRepsCompleted(32);
        model.addAttribute("repGoal", repGoal);

        return ("start");
    }

    //Created Page map for the UI
    @GetMapping("/createGoal")
    public String createGoalPage() {
        return "createGoal";
    }

}
