package com.fitnesstrackerapp.enterprise.dto;

import lombok.Data;
/**
 * @author Tanner
 * dto with lombok for the DistanceGoals, this is a subclass of goal that will be used when a user picks a distance
 * goal as their goal type
 */

public @Data class DistanceGoal extends Goal {
    private int typeId;
    private String goalType;
    private double DistanceToComplete;
    private double DistanceCompleted;
}
