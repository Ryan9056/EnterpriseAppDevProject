package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dao.IGoalDAO;
import com.fitnesstrackerapp.enterprise.dto.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService implements IGoalService {

    @Autowired
    private IGoalDAO goalDAO;

    @Override
    public Goal fetchById(int goalId) throws Exception {
        return goalDAO.fetchById(goalId);
    }

    @Override
    public Goal save(Goal goal) throws Exception {
        return goalDAO.save(goal);
    }

    @Override
    public List<Goal> fetchAll() throws Exception {
        return goalDAO.fetchAll();
    }
}