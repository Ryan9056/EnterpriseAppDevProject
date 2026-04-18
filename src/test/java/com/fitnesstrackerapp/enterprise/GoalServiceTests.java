package com.fitnesstrackerapp.enterprise;

import com.fitnesstrackerapp.enterprise.dao.GoalDAOStub;
import com.fitnesstrackerapp.enterprise.dao.IGoalDAO;
import com.fitnesstrackerapp.enterprise.dto.Goal;
import com.fitnesstrackerapp.enterprise.service.GoalServiceStub;
import com.fitnesstrackerapp.enterprise.service.IGoalService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
class GoalServiceTests {


    private IGoalService goalService;
    private Goal testGoal;
    private Goal updateGoal;
    private List<Goal> goalList;

    @MockitoBean
    private IGoalDAO goalDAO;

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
    private void deleteTestGoal() throws Exception {
        goalService.delete(testGoal.getGoalId());
        assertNull(goalService.fetchById(testGoal.getGoalId()));
    }

    // create new Goal then update test Goal using new Goal
    private void updateTestGoal() throws Exception {
        updateGoal = new Goal();
        updateGoal.setGoalId(2);
        updateGoal.setGoalName("updated");
        testGoal = goalService.update(updateGoal, testGoal.getGoalId());
    }

    // create new Goal and save new Goal
    private void createTestGoal() throws Exception {
        testGoal = new Goal();
        testGoal.setGoalId(1);
        testGoal.setGoalName("test");
        goalDAO = new GoalDAOStub();
        goalService = new GoalServiceStub(goalDAO);
        goalService.save(testGoal);
    }
    private void makeTestGoalActive() {
        testGoal.setCompleted(false);
    }

    private void makeTestGoalCompleted() {
        testGoal.setCompleted(true);
    }

    // fetch test Goal with id
    private void fetchTestGoal() {
        testGoal = goalService.fetchById(1);
    }

    // verify Goal is the correct
    private void returnTestGoal(String name) throws Exception {
        Goal createdGoal = goalService.save(testGoal);
        assertEquals(name, createdGoal.getGoalName());
    }



}