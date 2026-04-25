package com.fitnesstrackerapp.enterprise.dao;
import com.fitnesstrackerapp.enterprise.dto.Goal;

import java.util.List;

public interface IGoalDAO {
    Goal fetchById(int goalId) throws Exception;

    Goal save(Goal goal) throws Exception;

    List<Goal> fetchAll();

    List<Goal> fetchCompleted(int accountId);

    List<Goal> fetchNotCompleted(int accountId);

    void delete(int goalId) throws Exception;

    Goal update(Goal goal) throws Exception;
}
