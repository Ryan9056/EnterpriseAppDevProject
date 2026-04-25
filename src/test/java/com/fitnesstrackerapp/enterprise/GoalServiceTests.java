package com.fitnesstrackerapp.enterprise;

import com.fitnesstrackerapp.enterprise.dto.Account;
import com.fitnesstrackerapp.enterprise.dto.Goal;
import com.fitnesstrackerapp.enterprise.service.IAccountService;
import com.fitnesstrackerapp.enterprise.service.IGoalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoalServiceTests {


    @Autowired
    private IGoalService goalService;
    private Goal templateGoal;
        private Goal testGoal;
    private Goal updateGoal;
    private List<Goal> goalList;

    //Test for creating, fetching, and verifying creation of Goal using goal name and id
    @Test
    void createGoal_returnsTestGoal() throws Exception {
        createTestGoal();
        fetchTestGoal();
        returnTestGoal("test");
    }

    // Test for creating, fetching, updating, and verifying creation of Goal using Goal name and id
    @Test
    void updateGoal_returnsUpdatedGoal() throws Exception {
        createTestGoal();
        fetchTestGoal();
        updateTestGoal();
        returnTestGoal("updated");
    }

    // Test for creating, deleting and verifying deletion of a Goal using Goal name and id
    @Test
    void deleteGoal_returnsNull() throws Exception {
        createTestGoal();
        deleteTestGoal();
    }

    // Test for creating, setting Active, fetching, and verifying the Goal is Active
    @Test
    void fetchActiveGoals_returnsActiveGoal() throws Exception {
        createTestGoal();
        makeTestGoalActive();
        fetchActiveTestGoal();
        returnActiveTestGoal();
    }

    //Test for creating, setting Completed, fetching, and verifying the Goal is Completed
    @Test
    void fetchCompletedGoals_returnsCompletedGoal() throws Exception {
        createTestGoal();
        makeTestGoalCompleted();
        fetchCompletedTestGoal();
        returnCompletedTestGoal();
    }

    // Verifies if fetched goal is active
    private void returnActiveTestGoal() {
        boolean isActive = testGoal.getIsCompleted();
        assertFalse(isActive);
    }

    // Verifies if fetched goal is Completed
    private void returnCompletedTestGoal() {
        boolean isComplete = testGoal.getIsCompleted();
        assertTrue(isComplete);
    }

    // Fetches active goals
    private void fetchActiveTestGoal() throws Exception {
        goalList = goalService.InProgress(1);
        testGoal = goalList.get(0);
        testGoal.setIsCompleted(false);
    }

    // Fetches Completed Goals
    private void fetchCompletedTestGoal() throws Exception {
        goalList = goalService.AllComplete(1);
        testGoal = goalList.get(0);
    }

    // delete Goal using Goal id then checking is Goal is null
    private void deleteTestGoal() throws Exception {
        goalService.delete(templateGoal.getGoalId());
        assertNull(goalService.fetchById(templateGoal.getGoalId()));
    }

    // create new Goal then update test Goal using new Goal
    private void updateTestGoal() throws Exception {
        updateGoal = new Goal();
        updateGoal.setGoalId(2);
        updateGoal.setGoalName("updated");
        testGoal = goalService.update(updateGoal);
    }

    // create new Goal and save new Goal
    private void createTestGoal() throws Exception {
        templateGoal = new Goal();
        templateGoal.setGoalId(1);
        templateGoal.setAccountId(1);
        templateGoal.setGoalName("test");
        goalService.save(templateGoal);
    }
    private void makeTestGoalActive() {
        templateGoal.setIsCompleted(false);
    }

    private void makeTestGoalCompleted() {
        templateGoal.setIsCompleted(true);
    }

    // fetch test Goal with id
    private void fetchTestGoal() throws Exception {
        testGoal = goalService.fetchById(templateGoal.getGoalId());
    }

    // verify Goal is the correct
    private void returnTestGoal(String name) {
        String goalName = testGoal.getGoalName();
        assertEquals(name,goalName);
    }



}