package com.nhlstenden.workoutapp;

public class Activity
{
    private String description;
    private int timeInSeconds;
    private int startTime;

    public Activity(String description, int timeInSeconds, int startTime)
    {
        this.setDescription(description);
        this.setTimeInSeconds(timeInSeconds);
        this.setStartTime(startTime);
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        if (description == null || description.isBlank())
        {
            throw new IllegalArgumentException("Description cannot be null or blank.");
        }

        this.description = description;
    }

    public int getTimeInSeconds()
    {
        return this.timeInSeconds;
    }

    public void setTimeInSeconds(int timeInSeconds)
    {
        if (timeInSeconds <= 0)
        {
            throw new IllegalArgumentException("TimeInSeconds cannot be inferior or equal to zero.");
        }

        this.timeInSeconds = timeInSeconds;
    }

    public int getStartTime()
    {
        return this.startTime;
    }

    public void setStartTime(int startTime)
    {
        if (startTime < 0)
        {
            throw new IllegalArgumentException("StartTime cannot be negative.");
        }

        this.startTime = startTime;
    }

    public int getEndTime()
    {
        return this.getStartTime() + this.getTimeInSeconds();
    }
}