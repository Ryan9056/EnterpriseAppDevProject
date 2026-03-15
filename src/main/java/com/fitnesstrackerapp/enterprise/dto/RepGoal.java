package com.fitnesstrackerapp.enterprise.dto;

import lombok.Data;
/**
 * @author Tanner
 * dto with lombok for the RepGoals, this is a subclass of goal that will be used when a user picks a rep
 * goal as their goal type
 */
public @Data class RepGoal extends Goal {
    private int repGoalId;
    private String goalType;
    private double repsToComplete;
    private double repsCompleted;
}
