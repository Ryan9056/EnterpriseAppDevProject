package com.fitnesstrackerapp.enterprise;

import com.fitnesstrackerapp.enterprise.dto.Account;
import com.fitnesstrackerapp.enterprise.dto.DistanceGoal;
import com.fitnesstrackerapp.enterprise.dto.RepGoal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class FitnessAppController {
    /**
     * Handle the root (/) endpoint and return a start page @return (currently no start page)
     *
     */
    @RequestMapping("/")
    public String index(Model model){
        //Account Attribute
        Account account = new Account();
        account.setAccountId(1);
        account.setAccountName("Fred");
        account.setEmail("Fred@email");
        account.setPassword("password");
        model.addAttribute("account", account);

        //Distance Goal Attribute
        DistanceGoal dGoal = new DistanceGoal();
        dGoal.setGoalType("Miles");
        dGoal.setDistanceToComplete(5);
        dGoal.setDistanceCompleted(3);
        model.addAttribute("dGoal", dGoal);

        //Distance Goal Attribute
        RepGoal repGoal = new RepGoal();
        repGoal.setGoalType("Sit Ups");
        repGoal.setRepsToComplete(50);
        repGoal.setRepsCompleted(32);
        model.addAttribute("repGoal", repGoal);

        return ("start");
    }
}
