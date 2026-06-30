package com.nhlstenden.workoutapp;

import java.util.ArrayList;
import java.util.List;

public class Workout
{
    // Given inconsistency between the diagram and the text I opted to follow the information of the text
    // regarding minimum difficulty threshold.
    private final static int MIN_DIFFICULTY = 1;
    private final static int MAX_DIFFICULTY = 5;

    private String name;
    private double difficulty;
    private List<Activity> activities;

    public Workout(String name, double difficulty)
    {
        this.setName(name);
        this.setDifficulty(difficulty);
        this.setActivities(new ArrayList<>());
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }

        this.name = name;
    }

    public double getDifficulty()
    {
        return this.difficulty;
    }

    public void setDifficulty(double difficulty)
    {
        if (difficulty < MIN_DIFFICULTY || difficulty > MAX_DIFFICULTY)
        {
            throw new IllegalArgumentException("Difficulty cannot has to be between 1 up to 5 stars in difficulty.");
        }

        this.difficulty = difficulty;
    }

    public List<Activity> getActivities()
    {
        return this.activities;
    }

    public void setActivities(List<Activity> activities)
    {
        if (activities == null)
        {
            throw new IllegalArgumentException("Activities cannot be null.");
        }

        this.activities = activities;
    }

    public void addActivities(Activity activity)
    {
        if (activity == null)
        {
            throw new IllegalArgumentException("Activity cannot be null.");
        }

        if (!this.getActivities().isEmpty())
        {
            if (activity.getStartTime() < this.getActivities().getLast().getEndTime())
            {
                throw new IllegalArgumentException("Cannot add this activity because it overlaps with existing ones.");
            }
        }

        this.getActivities().add(activity);
    }

    public void removeActivity(Activity activity)
    {
        if (activity == null)
        {
            throw new IllegalArgumentException("Activity cannot be null.");
        }

        if (!this.getActivities().contains(activity))
        {
            throw new IllegalArgumentException("This activity does not exist in the system.");
        }

        this.getActivities().remove(activity);
    }

    public int getTotalDuration()
    {
        return this.getActivities().getLast().getEndTime();
    }

    // Helper method to divide responsibilities
    private int getTotalSecondsOfActivities()
    {
        int totalSecondsOfActivities = 0;

        for (Activity activity : this.getActivities())
        {
            totalSecondsOfActivities += activity.getTimeInSeconds();
        }

        return totalSecondsOfActivities;
    }

    public int getTotalSecondsOfBreak()
    {
        return getTotalDuration() - getTotalSecondsOfActivities();
    }

    public String getWorkoutDescription()
    {
        String workoutDescription = String.format("{}\n", this.getName());

        for (int i = 0; i < this.getActivities().size(); i++)
        {
            Activity currentActivity = this.getActivities().get(i);

            workoutDescription += String.format("{}) {} ({} seconds)\n", i + 1, currentActivity, currentActivity.getTimeInSeconds());
        }

        return workoutDescription;
    }
}