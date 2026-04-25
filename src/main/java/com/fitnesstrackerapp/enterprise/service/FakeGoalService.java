package com.fitnesstrackerapp.enterprise.service;


import com.fitnesstrackerapp.enterprise.dto.DistanceGoal;
import com.fitnesstrackerapp.enterprise.dto.Goal;
import com.fitnesstrackerapp.enterprise.dto.RepGoal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Service
public class FakeGoalService implements IGoalService {

    private final Map<Integer, Goal> testGoals = new HashMap<>();

    public FakeGoalService() {

        // Distance Goal
        DistanceGoal dGoal = new DistanceGoal();
        dGoal.setGoalId(1);
        dGoal.setAccountId(1);
        dGoal.setDistanceToComplete(5.0);
        dGoal.setDistanceCompleted(3.0);

        // Rep Goal
        RepGoal repGoal = new RepGoal();
        repGoal.setGoalId(2);
        repGoal.setAccountId(1);
        repGoal.setRepsToComplete(50.0);
        repGoal.setRepsCompleted(9.0);

        testGoals.put(1, dGoal);
        testGoals.put(2, repGoal);
    }

    @Override
    public Goal fetchById(int id) {
        return testGoals.get(id);
    }

    @Override
    public Goal save(Goal goal) {
        if (goal.getGoalId() == 0) {
            goal.setGoalId(testGoals.size() + 1);
        }
        testGoals.put(goal.getGoalId(), goal);
        return goal;
    }

    @Override
    public List<Goal> fetchAll() throws Exception {
        return new ArrayList<>(testGoals.values());
    }

    @Override
    public List<Goal> AllComplete() throws Exception {
        return List.of();
    }

    @Override
    public List<Goal> InProgress() throws Exception {
        return List.of();
    }

    @Override
    public Goal update(Goal goal) throws Exception {
        return null;
    }

    @Override
    public void delete(int goalId) {

    }
}