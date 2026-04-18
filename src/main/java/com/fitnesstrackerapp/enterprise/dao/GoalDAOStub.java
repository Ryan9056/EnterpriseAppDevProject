package com.fitnesstrackerapp.enterprise.dao;

import com.fitnesstrackerapp.enterprise.dto.Goal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GoalDAOStub implements IGoalDAO {
    Map<Integer, Goal> allGoals = new HashMap<>();

    @Override
    public Goal save(Goal goal) throws Exception {
        int goalId = goal.getGoalId();
        allGoals.put(goalId,goal);
        return goal;
    }

    @Override
    public Goal fetch(int goalId) {
        return allGoals.get(goalId);
    }

    @Override
    public void delete(int goalId) throws Exception {
        allGoals.remove(goalId);
    }

    @Override
    public List<Goal> fetchAll() {
        List<Goal> returngoals = new ArrayList(allGoals.values());
        return returngoals;
    }

    @Override
    public Goal update(Goal goal, int goalId) throws Exception {
        allGoals.put(goalId, goal);
        return goal;
    }
}
