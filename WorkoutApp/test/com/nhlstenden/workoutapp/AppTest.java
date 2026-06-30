package com.nhlstenden.workoutapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest
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
        this.activity3 = new Activity("Abdominal crunches", 30, 20);

        this.workout1 = new Workout("Improve your core", 3);
        this.workout2 = new Workout("Workout2", 1);

        this.app = new App();

        workout1.addActivities(activity1);
        workout1.addActivities(activity2);
    }

    // ---------------------Extra Unit Tests for myself-----------------------------

    @Test
    void getWorkoutsLongerThan10Minutes_1LongWorkOut_shouldReturnListSize1()
    {
        // Arrange
        Activity activity4 = new Activity("activity4", 550, 51);

        workout2.addActivities(activity1);
        workout2.addActivities(activity2);
        workout2.addActivities(activity4);

        app.addWorkout(workout1);
        app.addWorkout(workout2);

        // Action + Assert
        assertEquals(1, app.getWorkoutsLongerThan10Minutes().size());
    }

    @Test
    void removeWorkoutsLongerThan10Minutes_1LongWorkOut_shouldRemoveWorkoutFromApp()
    {
        // Arrange
        Activity activity4 = new Activity("activity4", 550, 51);

        workout2.addActivities(activity1);
        workout2.addActivities(activity2);
        workout2.addActivities(activity4);

        app.addWorkout(workout1);
        app.addWorkout(workout2);

        // Action
        app.removeWorkoutsLongerThan10Minutes();

        // Action + Assert
        assertEquals(1, app.getWorkouts().size());
    }

    @Test
    void removeWorkoutsLongerThan10Minutes_2LongWorkOut_shouldRemoveWorkoutsFromApp()
    {
        // Arrange
        Workout workout3 = new Workout("Workout3", 4);
        Activity activity4 = new Activity("activity4", 550, 51);

        workout2.addActivities(activity1);
        workout2.addActivities(activity2);
        workout2.addActivities(activity4);

        workout3.addActivities(activity1);
        workout3.addActivities(activity2);
        workout3.addActivities(activity4);

        app.addWorkout(workout1);
        app.addWorkout(workout2);
        app.addWorkout(workout3);

        // Action
        app.removeWorkoutsLongerThan10Minutes();

        // Assert
        assertEquals(1, app.getWorkouts().size());
    }

    @Test
    void returnAndRemoveWorkoutsLongerThan10Minutes_2LongWorkoutsOutOf3_shouldReturn2AndRemoveThem()
    {
        // Arrange
        Workout workout3 = new Workout("Workout3", 4);
        Activity activity4 = new Activity("activity4", 550, 51);

        workout2.addActivities(activity1);
        workout2.addActivities(activity2);
        workout2.addActivities(activity4);

        workout3.addActivities(activity1);
        workout3.addActivities(activity2);
        workout3.addActivities(activity4);

        app.addWorkout(workout1);
        app.addWorkout(workout2);
        app.addWorkout(workout3);

        // Action + Assert
        assertEquals(2, app.returnAndRemoveWorkoutsLongerThan10Minutes().size());
        assertEquals(1, app.getWorkouts().size());
    }

    // ------------------------On exam I would have deleted these----------------------------------

    @Test
    void addWorkout_nullWorkout_shouldThrowExceptionAndNotAddWorkout()
    {
        assertThrows(IllegalArgumentException.class, () -> app.addWorkout(null));
        assertEquals(0, app.getWorkouts().size());
    }

    @Test
    void addWorkout_validWorkout_shouldNotThrowAndAddWorkout()
    {
        assertDoesNotThrow(() -> app.addWorkout(workout1));
        assertEquals(1, app.getWorkouts().size());
    }

    @Test
    void addWorkout_existingWorkout_shouldThrowExceptionAndNotAddWorkout()
    {
        // Arrange
        app.addWorkout(workout1);

        // Action + Assert
        assertThrows(IllegalArgumentException.class, () -> app.addWorkout(workout1));
        assertEquals(1, app.getWorkouts().size());
    }
}