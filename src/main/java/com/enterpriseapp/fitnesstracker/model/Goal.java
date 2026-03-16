package com.enterpriseapp.fitnesstracker.model;

import java.time.LocalDate;

public class Goal {

    private int goalId;
    private int accountId;
    private String goalName;
    private LocalDate entryDate;
    private LocalDate completionDate;

    public Goal(int goalId, int accountId, String goalName,
                LocalDate entryDate, LocalDate completionDate) {
        this.goalId = goalId;
        this.accountId = accountId;
        this.goalName = goalName;
        this.entryDate = entryDate;
        this.completionDate = completionDate;
    }

    public int getGoalId() {
        return goalId;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getGoalName() {
        return goalName;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }
}
