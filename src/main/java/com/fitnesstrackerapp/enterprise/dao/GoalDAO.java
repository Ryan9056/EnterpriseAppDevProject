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

@Repository
public class GoalDAO implements IGoalDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Goal fetchById(int goalId) throws Exception {
        Goal goal = entityManager.find(Goal.class, goalId);

        if (goal == null) {
            throw new Exception("Goal not found with id: " + goalId);
        }

        return goal;
    }

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

    @Override
    public List<Goal> fetchAll() {
        TypedQuery<Goal> query =
                entityManager.createQuery("SELECT g FROM Goal g", Goal.class);
        return query.getResultList();
    }

    @Override
    public List<Goal> fetchCompleted() {
        TypedQuery<Goal> query =
                entityManager.createQuery("SELECT g FROM Goal g WHERE g.isCompleted = true", Goal.class);
        return query.getResultList();
    }

    @Override
    public List<Goal> fetchNotCompleted() {
        TypedQuery<Goal> query =
                entityManager.createQuery("SELECT g FROM Goal g WHERE g.isCompleted = false", Goal.class);
        return query.getResultList();
    }


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
