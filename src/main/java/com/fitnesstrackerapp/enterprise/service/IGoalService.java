package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dto.Goal;

import java.util.List;

public interface IGoalService {

    Goal fetchById(int goalId);

    Goal save(Goal goal);

    void delete(int goalId);

    Goal update(int goalId);

    List<Goal> fetchActiveGoals(int AccountId);

    List<Goal> fetchCompletedGoals(int AccountId);
}
