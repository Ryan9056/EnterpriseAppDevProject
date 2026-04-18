package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dao.IGoalDAO;
import com.fitnesstrackerapp.enterprise.dto.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalServiceStub implements IGoalService {

    @Autowired
    private IGoalDAO goalDAO;

    public GoalServiceStub() {

    }

    public GoalServiceStub(IGoalDAO goalDAO) {
        this.goalDAO = goalDAO;
    }

    @Override
    public Goal fetchById(int goalId) {
        Goal foundGoal = goalDAO.fetch(goalId);
        return foundGoal;
    }

    @Override
    public Goal save(Goal goal) throws Exception {
        return goalDAO.save(goal);
    }

    @Override
    public Goal update(Goal goal, int goalId) throws Exception {
        return goalDAO.update(goal, goalId);
    }

    @Override
    public void delete(int goalId) throws Exception {
        goalDAO.delete(goalId);
    }

    @Override
    public List<Goal> fetchAll() {
        return goalDAO.fetchAll();
    }

    @Override
    public List<Goal> fetchActiveGoals(int AccountId) {
        return List.of();
    }

    @Override
    public List<Goal> fetchCompletedGoals(int AccountId) {
        return List.of();
    }
}
