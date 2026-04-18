package com.fitnesstrackerapp.enterprise.dao;

import com.fitnesstrackerapp.enterprise.dto.Goal;

import java.util.List;

public interface IGoalDAO {
    Goal save(Goal goal) throws Exception;

    Goal fetch(int goalId);

    void delete(int goalId) throws Exception;

    List<Goal> fetchAll();

    Goal update(Goal goal, int goalId) throws Exception;
}
