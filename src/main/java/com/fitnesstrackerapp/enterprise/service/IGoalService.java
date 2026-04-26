package com.fitnesstrackerapp.enterprise.service;

import com.fitnesstrackerapp.enterprise.dto.Goal;
import java.util.List;

/**
 * Service interface responsible for managing Goal entities.
 * <p>
 * Defines business operations for creating, retrieving, updating,
 * deleting, and filtering goals by completion status.
 */
public interface IGoalService {

    /**
     * Retrieves a goal by its unique identifier.
     *
     * @param goalId the ID of the goal to retrieve
     * @return the Goal associated with the given ID
     * @throws Exception if the goal cannot be found or retrieved
     */
    Goal fetchById(int goalId) throws Exception;

    /**
     * Saves a new goal to the system.
     *
     * @param goal the Goal to be created
     * @return the saved Goal
     * @throws Exception if the goal cannot be saved
     */
    Goal save(Goal goal) throws Exception;

    /**
     * Retrieves all goals in the system.
     *
     * @return a list of all goals; returns an empty list if none exist
     * @throws Exception if an error occurs during retrieval
     */
    List<Goal> fetchAll() throws Exception;

    /**
     * Retrieves all completed goals for an account.
     *
     * @param accountId the ID of the account
     * @return a list of completed goals for the account
     * @throws Exception if an error occurs during retrieval
     */
    List<Goal> AllComplete(int accountId) throws Exception;

    /**
     * Retrieves all in-progress goals for an account.
     *
     * @param accountId the ID of the account
     * @return a list of incomplete goals for the account
     * @throws Exception if an error occurs during retrieval
     */
    List<Goal> InProgress(int accountId) throws Exception;

    /**
     * Updates an existing goal.
     *
     * @param goal the Goal containing updated values
     * @return the updated Goal
     * @throws Exception if the goal cannot be found or updated
     */
    Goal update(Goal goal) throws Exception;

    /**
     * Deletes a goal by its ID.
     *
     * @param goalId the ID of the goal to delete
     * @throws Exception if the goal cannot be found or deleted
     */
    void delete(int goalId) throws Exception;

}
