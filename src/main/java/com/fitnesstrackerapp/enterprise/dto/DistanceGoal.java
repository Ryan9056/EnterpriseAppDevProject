package com.fitnesstrackerapp.enterprise.dto;

import jakarta.persistence.*;

/**
 * @author Tanner
 * dto for the DistanceGoals, this is a subclass of goal that will be used when a user picks a distance
 * goal as their goal type
 */

@Entity
@DiscriminatorValue("DISTANCE")
public class DistanceGoal extends Goal {

    @Column(name = "DISTANCE_TO_COMPLETE_GOAL")
    private Double distanceToComplete;

    @Column(name = "DISTANCE_COMPLETED_SO_FAR")
    private Double distanceCompleted;

    public DistanceGoal() {
    }

    public Double getDistanceToComplete() {
        return distanceToComplete;
    }

    public void setDistanceToComplete(Double distanceToComplete) {
        this.distanceToComplete = distanceToComplete;
    }

    public Double getDistanceCompleted() {
        return distanceCompleted;
    }

    public void setDistanceCompleted(Double distanceCompleted) {
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