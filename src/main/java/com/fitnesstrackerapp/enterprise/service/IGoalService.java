package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dto.Goal;

public interface IGoalService {

    Goal fetchById(int goalId);

    void save(Goal goal);

    void delete(int goalId);

    void update(int goalId, Goal goal);
}
