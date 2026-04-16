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
public class Goal {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goalId;



    @Column(nullable = false)
    private int accountId;

    public Goal(){}

}
