package com.fitnesstrackerapp.enterprise.dao;
import com.fitnesstrackerapp.enterprise.dto.Goal;


import java.util.List;

/**
 * Interface defining data access operations for Goal entities.
 * <p>
 * Provides method signatures for CRUD operations and specialized queries
 * related to goal completion status.
 */
public interface IGoalDAO {

    /**
     * Retrieves a Goal by its unique identifier.
     *
     * @param goalId the ID of the goal
     * @return the Goal associated with the given ID
     * @throws Exception if the goal is not found or the ID is invalid
     */
    Goal fetchById(int goalId) throws Exception;

    /**
     * Saves a new Goal to the database.
     *
     * @param goal the Goal to be persisted
     * @return the saved Goal
     * @throws Exception if the goal cannot be saved
     */
    Goal save(Goal goal) throws Exception;

    /**
     * Retrieves all goals from the database.
     *
     * @return a list of all goals; returns an empty list if none exist
     */
    List<Goal> fetchAll();

    /**
     * Retrieves all completed goals for a specific account.
     *
     * @param accountId the ID of the account
     * @return a list of completed goals
     */
    List<Goal> fetchCompleted(int accountId);

    /**
     * Retrieves all incomplete goals for a specific account.
     *
     * @param accountId the ID of the account
     * @return a list of incomplete goals
     */
    List<Goal> fetchNotCompleted(int accountId);

    /**
     * Deletes a Goal by its unique identifier.
     *
     * @param goalId the ID of the goal to delete
     * @throws Exception if the goal cannot be found or deleted
     */
    void delete(int goalId) throws Exception;

    /**
     * Updates an existing Goal.
     *
     * @param goal the Goal containing updated values
     * @return the updated Goal
     * @throws Exception if the goal cannot be found or updated
     */
    Goal update(Goal goal) throws Exception;

}
