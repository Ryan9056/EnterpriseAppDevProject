package com.fitnesstrackerapp.enterprise.dto;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
/**
 * Represents a repetition-based Goal in the system.
 * <p>
 * This class extends the Goal entity and is used when a user selects a goal
 * measured by repetitions (e.g., push-ups, sit-ups).
 * It is part of a single-table inheritance hierarchy and is distinguished
 * using a discriminator value of "REP".
 *
 * @author Tanner
 */
@Entity
@DiscriminatorValue("REP")
public class RepGoal extends Goal {

    @Column(name = "REPS_TO_COMPLETE_GOAL")
    private Double repsToComplete;

    @Column(name = "REPS_COMPLETED_SO_FAR")
    private Double repsCompleted;

    public RepGoal() {
    }

    public Double getRepsToComplete() {
        return repsToComplete;
    }

    public void setRepsToComplete(Double repsToComplete) {
        this.repsToComplete = repsToComplete;
    }

    public Double getRepsCompleted() {
        return repsCompleted;
    }

    public void setRepsCompleted(Double repsCompleted) {
        this.repsCompleted = repsCompleted;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RepGoal) {
            return ((RepGoal) obj).getGoalId() == this.getGoalId();
        }
        return false;
    }
}
