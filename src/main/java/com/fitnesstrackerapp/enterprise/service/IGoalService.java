package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dto.Goal;

import java.util.List;

public interface IGoalService {

    Goal fetchById(int goalId);

    Goal save(Goal goal) throws Exception;

    void delete(int goalId) throws Exception;

    Goal update(Goal goal, int goalId) throws Exception;

    List<Goal> fetchAll();

    List<Goal> fetchActiveGoals(int AccountId);

    List<Goal> fetchCompletedGoals(int AccountId);
}
