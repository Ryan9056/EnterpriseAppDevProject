package com.fitnesstrackerapp.enterprise;

import com.fitnesstrackerapp.enterprise.dto.Account;
import com.fitnesstrackerapp.enterprise.dto.Goal;
import com.fitnesstrackerapp.enterprise.service.IGoalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class GoalServiceTests {


    @Autowired
    private IGoalService goalService;
    private Goal templateGoal;
    private Goal testGoal;
    private Goal updateGoal;

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
    void deleteGoal() {
        createTestGoal();
        deleteTestGoal();
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
        templateGoal.setGoalName("test");
        goalService.save(templateGoal);
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