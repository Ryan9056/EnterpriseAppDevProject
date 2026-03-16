package com.enterpriseapp.fitnesstracker.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GoalTest {
  @Test
  void constructorSetsFields() {
    LocalDate entry = LocalDate.of(2025, 1, 1);
    LocalDate completion = LocalDate.of(2025, 3, 1);

    Goal goal = new Goal(
      1,
      10,
      "Run 4 times per week",
      entry,
      completion
    );

    assertEquals(1, goal.getGoalId());
    assertEquals(10, goal.getAccountId());
    assertEquals("Run 4 times per week", goal.getGoalName());
    assertEquals(entry, goal.getEntryDate());
    assertEquals(completion, goal.getCompleteDate());
  }
}
