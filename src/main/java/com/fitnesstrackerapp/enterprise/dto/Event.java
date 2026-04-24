package com.fitnesstrackerapp.enterprise.dto;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * @author Tanner
 * dto with lombok for Events, this will be used to log progress toward a goal
 * the value complete will be added to the ___Completed, judged against the ___toComplete,
 * and it will be determined if the goal has been completed upon logging a new event.
 */
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    @Column(nullable = false)
    private int accountId;

    @Column(nullable = false)
    private int goalId;

    @Column(nullable = false, length = 100)
    private String eventType;

    @Column(nullable = false)
    private double valueCompleted;

    @Column(nullable = false)
    private LocalDate eventDate;

    @Column(length = 255)
    private String notes;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public double getValueCompleted() {
        return valueCompleted;
    }

    public void setValueCompleted(double valueCompleted) {
        this.valueCompleted = valueCompleted;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Event) {
            return ((Event) obj).getEventId() == this.getEventId();
        }
        return false;
    }

    @Override
    public String toString() {
        return eventType + " " + valueCompleted + " " + eventDate;
    }
}
