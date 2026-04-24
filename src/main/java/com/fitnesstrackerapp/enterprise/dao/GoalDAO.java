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
        return entityManager.find(Goal.class, goalId);
    }

    @Override
    @Transactional
    public Goal save(Goal goal) throws Exception {
        if (goal.getGoalId() == 0) {
            entityManager.persist(goal);
            return goal;
        } else {
            return entityManager.merge(goal);
        }
    }

    @Override
    public List<Goal> fetchAll() throws Exception {
        TypedQuery<Goal> query =
                entityManager.createQuery("SELECT g FROM Goal g", Goal.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Goal update(Goal goal) throws Exception {

        Goal existingGoal = entityManager.find(Goal.class, goal.getGoalId());

        if (existingGoal == null) {
            throw new Exception("Goal not found with id: " + goal.getGoalId());
        }

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

            return entityManager.merge(existingDistanceGoal);
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

            return entityManager.merge(existingRepGoal);
        }

        throw new Exception("Goal type mismatch for id: " + goal.getGoalId());
    }

    @Override
    @Transactional
    public void delete(int goalId) throws Exception {
        Goal goal = entityManager.find(Goal.class, goalId);
        if (goal != null) {
            entityManager.remove(goal);
        }
    }

}
