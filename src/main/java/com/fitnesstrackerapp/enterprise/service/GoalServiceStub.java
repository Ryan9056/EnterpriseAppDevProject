package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dto.Goal;
import org.springframework.stereotype.Component;

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
    public void delete(int goalId) {

    }

    @Override
    public Goal update(int goalId) {
        return null;
    }
}
