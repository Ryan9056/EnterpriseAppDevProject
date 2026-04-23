package com.fitnesstrackerapp.enterprise.dao;

import com.fitnesstrackerapp.enterprise.dto.Goal;
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
}
