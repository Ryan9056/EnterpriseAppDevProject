package com.fitnesstrackerapp.enterprise.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
/**
 * @author Tanner
 * dto with lombok for the RepGoals, this is a subclass of goal that will be used when a user picks a rep
 * goal as their goal type
 */
@Entity
@Table(name = "rep_goals")
public class RepGoal extends Goal {

    @Column(nullable = false, name="goal_type")
    private String goalType;

    @Column(nullable = false, name="reps_to_complete_goal")
    private double repsToComplete;

    @Column(nullable = false, name="reps_completed_so_far")
    private double repsCompleted;

    public RepGoal(){}

    // getters and setters

    public String getGoalType() {
        return goalType;
    }

    public void setGoalType(String goalType) {
        this.goalType = goalType;
    }

    public double getRepsToComplete() {
        return repsToComplete;
    }

    public void setRepsToComplete(double repsToComplete) {
        this.repsToComplete = repsToComplete;
    }

    public double getRepsCompleted() {
        return repsCompleted;
    }

    public void setRepsCompleted(double repsCompleted) {
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
