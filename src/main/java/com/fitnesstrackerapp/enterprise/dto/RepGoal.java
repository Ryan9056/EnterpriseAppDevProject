package com.fitnesstrackerapp.enterprise.dto;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
/**
 * @author Tanner
 * dto with lombok for the RepGoals, this is a subclass of goal that will be used when a user picks a rep
 * goal as their goal type
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
