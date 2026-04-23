package com.fitnesstrackerapp.enterprise.dao;
import com.fitnesstrackerapp.enterprise.dto.Goal;

import java.util.List;

public interface IGoalDAO {
    Goal fetchById(int goalId) throws Exception;

    Goal save(Goal goal) throws Exception;

    List<Goal> fetchAll() throws Exception;
}
