package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dao.IGoalDAO;
import com.fitnesstrackerapp.enterprise.dto.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for Goal operations.
 * <p>
 * This class acts as the business logic layer for Goal entities,
 * delegating data access operations to the GoalDAO.
 * Despite the name "Stub", this class provides a full implementation
 * backed by the database.
 */
@Service
public class GoalServiceStub implements IGoalService {

    /**
     * DAO used to perform database operations for Goal entities.
     */
    @Autowired
    private IGoalDAO goalDAO;

    /**
     * Retrieves a goal by its ID.
     *
     * @param goalId the ID of the goal
     * @return the Goal associated with the given ID
     * @throws Exception if the goal cannot be found
     */
    @Override
    public Goal fetchById(int goalId) throws Exception {
        return goalDAO.fetchById(goalId);
    }

    /**
     * Saves a new goal.
     *
     * @param goal the Goal to be created
     * @return the saved Goal
     * @throws Exception if the goal cannot be saved
     */
    @Override
    public Goal save(Goal goal) throws Exception {
        return goalDAO.save(goal);
    }

    /**
     * Retrieves all goals.
     *
     * @return a list of all goals
     * @throws Exception if retrieval fails
     */
    @Override
    public List<Goal> fetchAll() throws Exception {
        return goalDAO.fetchAll();
    }

    /**
     * Retrieves all completed goals for an account.
     *
     * @param accountId the account ID
     * @return a list of completed goals
     * @throws Exception if retrieval fails
     */
    @Override
    public List<Goal> AllComplete(int accountId) throws Exception {
        return goalDAO.fetchCompleted(accountId);
    }

    /**
     * Retrieves all in-progress goals for an account.
     *
     * @param accountId the account ID
     * @return a list of incomplete goals
     * @throws Exception if retrieval fails
     */
    @Override
    public List<Goal> InProgress(int accountId) throws Exception {
        return goalDAO.fetchNotCompleted(accountId);
    }

    /**
     * Updates an existing goal.
     *
     * @param goal the Goal containing updated values
     * @return the updated Goal
     * @throws Exception if the goal cannot be updated
     */
    @Override
    public Goal update(Goal goal) throws Exception {
        return goalDAO.update(goal);
    }
    /**
     * Deletes a goal by its ID.
     *
     * @param goalId the ID of the goal to delete
     * @throws Exception if the goal cannot be deleted
     */
    @Override
    public void delete(int goalId) throws Exception {
        goalDAO.delete(goalId);
    }

}