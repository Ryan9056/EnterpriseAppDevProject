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
    public void save(Goal goal) {
    }

    @Override
    public void delete(int goalId) {

    }

    @Override
    public void update(int goalId, Goal goal) {

    }
}
