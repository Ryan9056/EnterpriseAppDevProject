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
    public List<Goal> FetchAll() throws Exception {
        return List.of();
    }
}
