package com.fitnesstrackerapp.enterprise.dao;

import com.fitnesstrackerapp.enterprise.dto.DistanceGoal;
import com.fitnesstrackerapp.enterprise.dto.Goal;
import com.fitnesstrackerapp.enterprise.dto.RepGoal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Data Access Object (DAO) for Goal entities.
 * <p>
 * Provides CRUD operations and specialized queries for goals, including
 * filtering based on completion status. Supports polymorphic handling
 * of DistanceGoal and RepGoal subclasses.
 */
@Repository
public class GoalDAO implements IGoalDAO {

    /**
     * JPA EntityManager used for database interactions.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Retrieves a Goal by its unique identifier.
     *
     * @param goalId the ID of the goal
     * @return the Goal associated with the given ID
     * @throws Exception if the goal is not found
     */
    @Override
    public Goal fetchById(int goalId) throws Exception {
        Goal goal = entityManager.find(Goal.class, goalId);

        if (goal == null) {
            throw new Exception("Goal not found with id: " + goalId);
        }

        return goal;
    }

    /**
     * Persists a new Goal to the database.
     *
     * @param goal the Goal to be saved
     * @return the persisted Goal
     * @throws RuntimeException if the goal is invalid or already has an ID
     */
    @Override
    @Transactional
    public Goal save(Goal goal) {
        if (goal == null) {
            throw new RuntimeException("Goal cannot be null");
        }

        if (goal.getAccountId() <= 0) {
            throw new RuntimeException("Goal must be associated with a valid account");
        }

        if (goal.getGoalId() != 0) {
            throw new RuntimeException("New goal should not already have an ID");
        }

        entityManager.persist(goal);
        return goal;
    }

    /**
     * Retrieves all goals from the database.
     *
     * @return a list of all goals; empty if none exist
     */
    @Override
    public List<Goal> fetchAll() {
        TypedQuery<Goal> query =
                entityManager.createQuery("SELECT g FROM Goal g", Goal.class);
        return query.getResultList();
    }

    /**
     * Retrieves all completed goals for a specific account.
     *
     * @param accountId the ID of the account
     * @return a list of completed goals
     */
    @Override
    public List<Goal> fetchCompleted(int accountId) {
        TypedQuery<Goal> query = entityManager.createQuery(
                "SELECT g FROM Goal g WHERE g.accountId = :accountId AND g.isCompleted = true",
                Goal.class
        );
        query.setParameter("accountId", accountId);
        return query.getResultList();
    }

    /**
     * Retrieves all incomplete goals for a specific account.
     *
     * @param accountId the ID of the account
     * @return a list of incomplete goals
     */
    @Override
    public List<Goal> fetchNotCompleted(int accountId) {
        TypedQuery<Goal> query = entityManager.createQuery(
                "SELECT g FROM Goal g WHERE g.accountId = :accountId AND g.isCompleted = false",
                Goal.class
        );
        query.setParameter("accountId", accountId);
        return query.getResultList();
    }

    /**
     * Updates an existing Goal in the database.
     * <p>
     * Only non-null fields are updated. Handles subclass-specific
     * fields for DistanceGoal and RepGoal.
     *
     * @param goal the Goal containing updated values
     * @return the updated Goal entity
     * @throws RuntimeException if the goal is invalid, not found, or mismatched type
     */
    @Override
    @Transactional
    public Goal update(Goal goal) {

        if (goal == null) {
            throw new RuntimeException("Goal cannot be null");
        }

        if (goal.getGoalId() == 0) {
            throw new RuntimeException("Goal must have an id to be updated");
        }

        Goal existingGoal = entityManager.find(Goal.class, goal.getGoalId());

        if (existingGoal == null) {
            throw new RuntimeException("Goal not found with id: " + goal.getGoalId());
        }

        existingGoal.setIsCompleted(goal.getIsCompleted());

        if (goal.getAccountId() != 0) {
            existingGoal.setAccountId(goal.getAccountId());
        }

        if (existingGoal instanceof DistanceGoal && goal instanceof DistanceGoal) {
            DistanceGoal existingDistanceGoal = (DistanceGoal) existingGoal;
            DistanceGoal updatedDistanceGoal = (DistanceGoal) goal;

            if (updatedDistanceGoal.getDistanceToComplete() != null) {
                existingDistanceGoal.setDistanceToComplete(updatedDistanceGoal.getDistanceToComplete());
            }

            if (updatedDistanceGoal.getDistanceCompleted() != null) {
                existingDistanceGoal.setDistanceCompleted(updatedDistanceGoal.getDistanceCompleted());
            }

            return existingDistanceGoal;
        }

        if (existingGoal instanceof RepGoal && goal instanceof RepGoal) {
            RepGoal existingRepGoal = (RepGoal) existingGoal;
            RepGoal updatedRepGoal = (RepGoal) goal;

            if (updatedRepGoal.getRepsToComplete() != null) {
                existingRepGoal.setRepsToComplete(updatedRepGoal.getRepsToComplete());
            }

            if (updatedRepGoal.getRepsCompleted() != null) {
                existingRepGoal.setRepsCompleted(updatedRepGoal.getRepsCompleted());
            }

            return existingRepGoal;
        }

        throw new RuntimeException("Goal type mismatch for id: " + goal.getGoalId());
    }



    /**
     * Deletes a Goal from the database by its ID.
     *
     * @param goalId the ID of the goal to delete
     * @throws RuntimeException if the ID is invalid or the goal does not exist
     */
    @Override
    @Transactional
    public void delete(int goalId) {

        if (goalId <= 0) {
            throw new RuntimeException("Invalid goal id");
        }

        Goal goal = entityManager.find(Goal.class, goalId);

        if (goal == null) {
            throw new RuntimeException("Goal not found with id: " + goalId);
        }

        entityManager.remove(goal);
    }

}
