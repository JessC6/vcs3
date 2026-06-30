package com.nhlstenden.workoutapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutTest
{
    private Activity activity1;
    private Activity activity2;
    private Activity activity3;

    private Workout workout1;
    private Workout workout2;

    private App app;

    @BeforeEach
    void setUp()
    {
        this.activity1 = new Activity("Do 20 squads",10, 0);
        this.activity2 = new Activity("Plank for 20 seconds", 20, 20);
        this.activity3 = new Activity("Abdominal crunches", 30, 60);

        this.workout1 = new Workout("Improve your core", 3);
        this.workout2 = new Workout("Workout2", 1);

        this.app = new App();

        app.addWorkout(workout1);

        workout1.addActivities(activity1);
        workout1.addActivities(activity2);
    }

    // ---------------------Extra Unit Tests for myself-----------------------------
    @Test
    void addActivity_overlappingActivities_shouldThrowExceptionAndNotAddActivity()
    {
        // Arrange
        Activity activity4 = new Activity("activity4", 30, 39);

        // Action + Assert
        assertThrows(IllegalArgumentException.class, () -> workout1.addActivities(activity4));
        assertEquals(2, workout1.getActivities().size());
    }

    @Test
    void getTotalDuration_removingActivity1_shouldReturn10()
    {
        // Arrange
        workout1.removeActivity(activity2);

        // Action + Assert
        assertEquals(10, workout1.getTotalDuration());
    }

    @Test
    void getTotalDuration_removingActivity2_shouldStillReturn40()
    {
        // Arrange
        workout1.removeActivity(activity1);

        // Action + Assert
        assertEquals(40, workout1.getTotalDuration());
    }

    @Test
    void getTotalDuration_2Activities_shouldReturn40()
    {
        assertEquals(40, workout1.getTotalDuration());
    }

    // ------------------------On exam I would have deleted these----------------------------------

    @Test
    void getTotalSecondsOfBreak_twoActivities_shouldReturn10()
    {
        assertEquals(10, workout1.getTotalSecondsOfBreak());
    }

    @Test
    void getTotalSecondsOfBreak_threeActivities_shouldReturn30()
    {
        // Arrange
        workout1.addActivities(activity3);

        // Action + Assert
        assertEquals(30, workout1.getTotalSecondsOfBreak());
    }

    @Test
    void getTotalSecondsOfBreak_threeActivitiesWithNoBreaks_shouldReturn0()
    {
        // Arrange
        workout1.removeActivity(activity2);

        Activity activity4 = new Activity("activity4", 20, 10);
        Activity activity5 = new Activity("activity5", 30, 30);

        workout1.addActivities(activity4);
        workout1.addActivities(activity5);

        // Action + Assert
        assertEquals(0, workout1.getTotalSecondsOfBreak());
    }
}