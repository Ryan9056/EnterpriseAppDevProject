package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dto.Goal;

import java.util.List;

public interface IGoalService {

    Goal fetchById(int goalId) throws Exception;

    Goal save(Goal goal) throws Exception;

    List<Goal> fetchAll() throws Exception;

    Goal update(Goal goal) throws Exception;

    void delete(int goalId) throws Exception;
}
