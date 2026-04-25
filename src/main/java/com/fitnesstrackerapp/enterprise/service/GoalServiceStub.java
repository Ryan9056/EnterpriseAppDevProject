package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dto.Goal;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoalServiceStub implements IGoalService {
    @Override
    public Goal fetchById(int goalId) {
        return null;
    }

    @Override
    public Goal save(Goal goal) {
        return null;
    }

    @Override
    public List<Goal> fetchAll() throws Exception {
        return List.of();
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
    public void delete(int goalId) throws Exception {
        return;
    }
}
