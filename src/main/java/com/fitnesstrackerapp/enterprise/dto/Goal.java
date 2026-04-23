package com.fitnesstrackerapp.enterprise.dto;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Tanner
 * dto with lombok for Goals, this is a superclass of the types of goals, it will be connected to the account
 * through the accountId, which will be considered a foreign key once we do the local db work.
 * This way once the account is logged in they will see their goals.
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
}