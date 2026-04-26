package com.fitnesstrackerapp.enterprise.dto;


import jakarta.persistence.*;


import java.util.Date;

/**
 * Represents a base Goal entity in the system.
 * <p>
 * This class serves as the superclass for all goal types (e.g., DistanceGoal, RepGoal)
 * and is mapped to the "goals" table using single-table inheritance.
 * Subclasses are distinguished by a discriminator column ("goal_type").
 *
 * Each goal is associated with an account via the accountId field,
 * which acts as a foreign key linking goals to users.
 *
 * @author Tanner
 */
@Entity
@Table(name = "goals")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "goal_type")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GOAL_ID")
    private int goalId;

    @Column(name = "ACCOUNT_ID", nullable = false)
    private int accountId;

    @Column(name = "GOAL_NAME", nullable = true)
    private String goalName;

    @Column(name = "IS_COMPLETED", nullable = false)
    private boolean isCompleted;

    @Column(name = "COMPLETION_DATE", nullable = false)
    private Date completionDate;

    public Goal() {
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getGoalName(){return goalName;}

    public void setGoalName(String goalName){this.goalName = goalName;}

    public boolean getIsCompleted(){return isCompleted;}

    public void setIsCompleted(boolean isCompleted){this.isCompleted = isCompleted;}

    public Date getCompletionDate(){return completionDate;}

    public void setCompletionDate(Date completionDate){this.completionDate = completionDate;}
}
