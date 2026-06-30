package com.nhlstenden.workoutapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App
{
    private List<Workout> workouts;

    // Creation of extra variable because of Magic Numbers possibility
    private static final int LONG_WORKOUT_TIME_IN_SECONDS = 600; // 10 minutes

    public App()
    {
        this.setWorkouts(new ArrayList<>());
    }

    public List<Workout> getWorkouts()
    {
        return this.workouts;
    }

    public void setWorkouts(List<Workout> workouts)
    {
        if (workouts == null)
        {
            throw new IllegalArgumentException("Workouts cannot be null.");
        }

        this.workouts = workouts;
    }

    public void addWorkout(Workout workout)
    {
        if (workout == null)
        {
            throw new IllegalArgumentException("Workout cannot be null.");
        }

        if (this.getWorkouts().contains(workout))
        {
            throw new IllegalArgumentException("This workout already exists in the system");
        }

        for (Workout existingWorkout : this.getWorkouts())
        {
            if (existingWorkout.getName().equalsIgnoreCase(workout.getName()))
            {
                throw new IllegalArgumentException("A workout with this name already exists in the system.");
            }
        }

        this.getWorkouts().add(workout);
    }

    public void removeWorkout(Workout workout)
    {
        if (workout == null)
        {
            throw new IllegalArgumentException("Workout cannot be null.");
        }

        if (!this.getWorkouts().contains(workout))
        {
            throw new IllegalArgumentException("This workout does not exist in the system");
        }

        this.getWorkouts().remove(workout);
    }

    // Since exercise 2 requests to return workouts longer than 10 minutes and remove them, those are two different
    // responsibilities, so I created two different methods, one that returns them, other that uses that list to remove them
    public List<Workout> getWorkoutsLongerThan10Minutes()
    {
        List<Workout> longWorkouts = new ArrayList<>();

        for (Workout workout : this.getWorkouts())
        {
            if (workout.getTotalDuration() > LONG_WORKOUT_TIME_IN_SECONDS)
            {
                longWorkouts.add(workout);
            }
        }

        return longWorkouts;
    }

    public void removeWorkoutsLongerThan10Minutes()
    {
        this.getWorkouts().removeAll(this.getWorkoutsLongerThan10Minutes());
    }

    // Method that returns and removes long workouts
    public List<Workout> returnAndRemoveWorkoutsLongerThan10Minutes()
    {
        List<Workout> longWorkouts = new ArrayList<>();
        Iterator<Workout> workouts = this.getWorkouts().iterator();

        while (workouts.hasNext())
        {
            Workout workout = workouts.next();

            if (workout.getTotalDuration() > LONG_WORKOUT_TIME_IN_SECONDS)
            {
                longWorkouts.add(workout);
                workouts.remove();
            }
        }

        return longWorkouts;
    }
}
