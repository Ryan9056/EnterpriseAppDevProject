package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dto.Goal;

public interface IGoalService {

    Goal fetchById(int goalId);

    Goal save(Goal goal);
}
