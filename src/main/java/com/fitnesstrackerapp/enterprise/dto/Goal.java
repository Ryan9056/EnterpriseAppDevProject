package com.fitnesstrackerapp.enterprise.dto;

import lombok.Data;
import java.time.LocalDate;
/**
 * @author Tanner
 * dto with lombok for Goals, this is a superclass of the types of goals, it will be connected to the account
 * through the accountId, which will be considered a foreign key once we do the local db work.
 * This way once the account is logged in they will see their goals.
 */
public @Data class Goal {
    private int goalId;
    private int accountId;
    private String goalName;
    private LocalDate entryDate;
    private LocalDate completionDate;
}
