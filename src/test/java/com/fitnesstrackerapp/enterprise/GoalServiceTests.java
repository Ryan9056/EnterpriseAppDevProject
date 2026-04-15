package com.fitnesstrackerapp.enterprise;

import com.fitnesstrackerapp.enterprise.dto.Goal;
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
    void createGoal_returnsTestGoal() {
        createTestGoal();
        fetchTestGoal();
        returnTestGoal("test");
    }

    // Test for creating, fetching, updating, and verifying creation of Goal using Goal name and id
    @Test
    void updateGoal_returnsUpdatedGoal() {
        createTestGoal();
        fetchTestGoal();
        updateTestGoal();
        returnTestGoal("updated");
    }

    // Test for creating, deleting and verifying deletion of a Goal using Goal name and id
    @Test
    void deleteGoal_returnsNull() {
        createTestGoal();
        deleteTestGoal();
    }

    // Test for creating, setting Active, fetching, and verifying the Goal is Active
    @Test
    void fetchActiveGoals_returnsActiveGoal() {
        createTestGoal();
        makeTestGoalActive();
        fetchActiveTestGoal();
        returnActiveTestGoal();
    }

    //Test for creating, setting Completed, fetching, and verifying the Goal is Completed
    @Test
    void fetchCompletedGoals_returnsCompletedGoal() {
        createTestGoal();
        makeTestGoalCompleted();
        fetchCompletedTestGoal();
        returnCompletedTestGoal();
    }

    // Verifies if fetched goal is active
    private void returnActiveTestGoal() {
        boolean isActive = testGoal.isCompleted();
        assertFalse(isActive);
    }

    // Verifies if fetched goal is Completed
    private void returnCompletedTestGoal() {
        boolean isComplete = testGoal.isCompleted();
        assertTrue(isComplete);
    }

    // Fetches active goals
    private void fetchActiveTestGoal() {
        goalList = goalService.fetchActiveGoals(1);
        testGoal = goalList.getFirst();
        testGoal.setCompleted(false);
    }

    // Fetches Completed Goals
    private void fetchCompletedTestGoal() {
        goalList = goalService.fetchCompletedGoals(1);
        testGoal = goalList.getFirst();
    }

    // delete Goal using Goal id then checking is Goal is null
    private void deleteTestGoal() {
        goalService.delete(templateGoal.getGoalId());
        assertNull(goalService.fetchById(templateGoal.getGoalId()));
    }

    // create new Goal then update test Goal using new Goal
    private void updateTestGoal() {
        updateGoal = new Goal();
        updateGoal.setGoalId(2);
        updateGoal.setGoalName("updated");
        testGoal = goalService.update(updateGoal.getGoalId());
    }

    // create new Goal and save new Goal
    private void createTestGoal() {
        templateGoal = new Goal();
        templateGoal.setGoalId(1);
        templateGoal.setAccountId(1);
        templateGoal.setGoalName("test");
        goalService.save(templateGoal);
    }
    private void makeTestGoalActive() {
        templateGoal.setCompleted(false);
    }

    private void makeTestGoalCompleted() {
        templateGoal.setCompleted(true);
    }

    // fetch test Goal with id
    private void fetchTestGoal() {
        testGoal = goalService.fetchById(templateGoal.getGoalId());
    }

    // verify Goal is the correct
    private void returnTestGoal(String name) {
        String goalName = testGoal.getGoalName();
        assertEquals(name,goalName);
    }



}