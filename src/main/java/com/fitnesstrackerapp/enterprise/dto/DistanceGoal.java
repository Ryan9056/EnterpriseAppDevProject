package com.fitnesstrackerapp.enterprise.dto;

import jakarta.persistence.*;

/**
 * @author Tanner
 * dto for the DistanceGoals, this is a subclass of goal that will be used when a user picks a distance
 * goal as their goal type
 */

@Entity
@Table(name = "distance_goals")
public class DistanceGoal extends Goal {

    @Column(nullable = false, name="goal_type")
    private String goalType;

    @Column(nullable = false, name="distance_to_complete_goal")
    private double distanceToComplete;

    @Column(nullable = false, name="distance_completed_so_far")
    private double distanceCompleted;

    public DistanceGoal(){}

    public String getGoalType() {
        return goalType;
    }

    public void setGoalType(String goalType) {
        this.goalType = goalType;
    }

    public double getDistanceToComplete() {
        return distanceToComplete;
    }

    public void setDistanceToComplete(double distanceToComplete) {
        this.distanceToComplete = distanceToComplete;
    }

    public double getDistanceCompleted() {
        return distanceCompleted;
    }

    public void setDistanceCompleted(double distanceCompleted) {
        this.distanceCompleted = distanceCompleted;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DistanceGoal) {
            return ((DistanceGoal) obj).getGoalId() == this.getGoalId();
        }
        return false;
    }
}