package com.fitnesstrackerapp.enterprise;

import com.fitnesstrackerapp.enterprise.dto.*;
import com.fitnesstrackerapp.enterprise.service.IAccountService;
import com.fitnesstrackerapp.enterprise.service.IEventService;
import com.fitnesstrackerapp.enterprise.service.IGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class FitnessAppController {

    @Autowired
    IAccountService accountService;
    @Autowired
    IGoalService goalService;
    @Autowired
    IEventService eventService;

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

    @GetMapping("/account")
    @ResponseBody
    public List<Account> fetchAllAccounts() {
        return accountService.fetchAll();
    }

    @GetMapping("/account/{id}/")
    public ResponseEntity fetchAccountById(@PathVariable("id") int id) {
        Account account = accountService.fetchById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(account, headers, HttpStatus.OK);
    }

    @PostMapping(value="/account", consumes="application/json", produces="application/json")
    public Account createAccount(@RequestBody Account account) {
        Account newAccount = null;
        try {
            newAccount = accountService.save(account);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return newAccount;
    }

    @DeleteMapping("/account/{id}/")
    public ResponseEntity deleteAccountById(@PathVariable("id") int id) {

        try {
            accountService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/account/{id}/",  consumes="application/json", produces="application/json")
    @ResponseBody
    public Account updateAccount(@PathVariable("id") int id, @RequestBody Account account) {

        Account updatedAccount = null;
        try {
            updatedAccount = accountService.update(account, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return updatedAccount;

    }

    @GetMapping("/goal")
    @ResponseBody
    public List<Goal> fetchAllGoals() {
        return goalService.fetchAll();
    }

    @GetMapping("/goal/{id}/")
    public ResponseEntity fetchGoalById(@PathVariable("id") int id) {
        Goal goal = goalService.fetchById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(goal, headers, HttpStatus.OK);
    }

    @PostMapping(value="/goal", consumes="application/json", produces="application/json")
    public Goal createGoal(@RequestBody Goal goal) {
        Goal newGoal = null;
        try {
            newGoal = goalService.save(goal);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return newGoal;
    }

    @DeleteMapping("/goal/{id}/")
    public ResponseEntity deleteGoalById(@PathVariable("id") int id) {

        try {
            goalService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/goal/{id}/",  consumes="application/json", produces="application/json")
    @ResponseBody
    public Goal updateAccount(@PathVariable("id") int id, @RequestBody Goal goal) {

        Goal updatedGoal = null;
        try {
            updatedGoal = goalService.update(goal, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return updatedGoal;

    }

    @GetMapping("/event")
    @ResponseBody
    public List<Event> fetchAllEvent() {
        return eventService.fetchAll();
    }

    @GetMapping("/event/{id}/")
    public ResponseEntity fetchEventById(@PathVariable("id") int id) {
        Event event = eventService.fetchById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(event, headers, HttpStatus.OK);
    }

    @PostMapping(value="/event", consumes="application/json", produces="application/json")
    public Event createEvent(@RequestBody Event event) {
        Event newEvent = null;
        try {
            newEvent = eventService.save(event);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return newEvent;
    }

    @DeleteMapping("/event/{id}/")
    public ResponseEntity deleteEventById(@PathVariable("id") int id) {

        try {
            eventService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/event/{id}/",  consumes="application/json", produces="application/json")
    @ResponseBody
    public Event updateEvent(@PathVariable("id") int id, @RequestBody Event event) {

        Event updatedEvent = null;
        try {
            updatedEvent = eventService.update(event, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return updatedEvent;

    }

    //Created Page map for the UI
    @GetMapping("/createGoal")
    public String createGoalPage() {
        return "createGoal";
    }

}
