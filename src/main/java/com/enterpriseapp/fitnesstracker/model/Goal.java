package com.enterpriseapp.fitnesstracker.model;
import java.time.LocalDate;

/**
 * Represents a fitness goal created by a user account.
 * Stores goal metadata including name, entry date, and target completion date.
 */
public class Goal {
    private int goalId;
    private int accountId;
    private String goalName;
    private LocalDate entryDate;
    private LocalDate completionDate;

    /**
     * Constructs a Goal with all required fields.
     * @param goalId unique identifier for the goal
     * @param accountId the account this goal belongs to
     * @param goalName name of the goal, must not be null or empty
     * @param entryDate date the goal was created
     * @param completionDate target date to complete the goal
     */
    public Goal(int goalId, int accountId, String goalName,
                LocalDate entryDate, LocalDate completionDate) {
        if (goalName == null || goalName.isEmpty()) {
            throw new IllegalArgumentException("goalName must not be null or empty");
        }
        this.goalId = goalId;
        this.accountId = accountId;
        this.goalName = goalName;
        this.entryDate = entryDate;
        this.completionDate = completionDate;
    }

    /** @return the goal's unique ID */
    public int getGoalId() { return goalId; }

    /** @return the account ID associated with this goal */
    public int getAccountId() { return accountId; }

    /** @return the name of the goal */
    public String getGoalName() { return goalName; }

    /** @return the date the goal was created */
    public LocalDate getEntryDate() { return entryDate; }

    /** @return the target completion date */
    public LocalDate getCompletionDate() { return completionDate; }

    /**
     * Updates the goal name.
     * @param goalName new name, must not be null or empty
     */
    public void setGoalName(String goalName) {
        if (goalName == null || goalName.isEmpty()) {
            throw new IllegalArgumentException("goalName must not be null or empty");
        }
        this.goalName = goalName;
    }

    /**
     * Updates the target completion date.
     * @param completionDate new completion date
     */
    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    /**
     * Returns a string representation of the Goal for debugging purposes.
     * @return formatted string with goal details
     */
    @Override
    public String toString() {
        return "Goal{" +
                "goalId=" + goalId +
                ", accountId=" + accountId +
                ", goalName='" + goalName + '\'' +
                ", entryDate=" + entryDate +
                ", completionDate=" + completionDate +
                '}';
    }
}
