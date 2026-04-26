package com.fitnesstrackerapp.enterprise.dto;

import jakarta.persistence.*;

/**
 * Represents a Distance-based Goal in the system.
 * <p>
 * This class extends the Goal entity and is used when a user selects a goal
 * that is measured by distance (e.g., miles or kilometers).
 * It is part of a single-table inheritance hierarchy and is distinguished
 * using a discriminator value of "DISTANCE".
 *
 * @author Tanner
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