package com.fitnesstrackerapp.enterprise;

import com.fitnesstrackerapp.enterprise.dto.Account;
import com.fitnesstrackerapp.enterprise.dto.Event;
import com.fitnesstrackerapp.enterprise.dto.Goal;
import com.fitnesstrackerapp.enterprise.service.IAccountService;
import com.fitnesstrackerapp.enterprise.service.IEventService;
import com.fitnesstrackerapp.enterprise.service.IGoalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FitnessAppApplicationTests {


    @Autowired
    private IAccountService accountService;
    @Autowired
    private IGoalService goalService;
    @Autowired
    private IEventService eventService;
    private Account templateaccount;
    private Account testAccount;
    private Goal templateGoal;
    private Goal testGoal;
    private Event templateEvent;
    private Event testEvent;

    //Test for creating, fetching, and verifying creation of Account using account name and id
    @Test
    void createAccount_returnsTestAccount() {
        createTestAccount();
        fetchTestAccount();
        returnTestAccount();
    }

    private void createTestAccount() {
        templateaccount = new Account();
        templateaccount.setAccountId(1);
        templateaccount.setAccountName("test");
        accountService.save(templateaccount);
    }

    private void fetchTestAccount() {
        testAccount = accountService.fetchById(templateaccount.getAccountId());
    }

    private void returnTestAccount() {
       String accountName = testAccount.getAccountName();
       assertEquals("test",accountName);
    }

    //Test for creating, fetching, and verifying creation of Goal using goal name and id
    @Test
    void createGoal_returnsTestGoal() throws Exception {
        createTestGoal();
        fetchTestGoal();
        returnTestGoal();
    }

    private void createTestGoal() throws Exception {
        templateGoal = new Goal();
        templateGoal.setGoalId(1);
        templateGoal.setGoalName("test");
        goalService.save(templateGoal);
    }

    private void fetchTestGoal() throws Exception {
        testGoal = goalService.fetchById(templateGoal.getGoalId());
    }

    private void returnTestGoal() {
        String goalName = testGoal.getGoalName();
        assertEquals("test",goalName);
    }

    //Test for creating, fetching, and verifying creation of Event using event type and id
    @Test
    void createEvent_returnsTestEvent() {
        createTestEvent();
        fetchTestEvent();
        returnTestEvent();
    }

    private void createTestEvent() {
        templateEvent = new Event();
        templateEvent.setEventId(1);
        templateEvent.setEventType("test");
        eventService.save(templateEvent);
    }

    private void fetchTestEvent() {
        testEvent = eventService.fetchById(templateEvent.getEventId());
    }

    private void returnTestEvent() {
        String eventType = testEvent.getEventType();
        assertEquals("test",eventType);
    }



}
