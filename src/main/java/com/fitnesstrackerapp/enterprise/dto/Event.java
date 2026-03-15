package com.fitnesstrackerapp.enterprise.dto;

import lombok.Data;
/**
 * @author Tanner
 * dto with lombok for Events, this will be used to log progress toward a goal
 * the value complete will be added to the ___Completed, judged against the ___toComplete,
 * and it will be determined if the goal has been completed upon logging a new event.
 */
public @Data class Event {
    private int eventId;
    private int goalId;
    private String eventType;
    private String entryDate;
    private double addedGoalProgress;
}
