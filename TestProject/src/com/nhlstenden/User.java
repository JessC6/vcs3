package com.nhlstenden;

import java.time.LocalDate;
import java.time.Period;

public class User
{
    private String name;
    private String surname;
    private LocalDate birthdate;

    public User(String name, String surname, LocalDate birthdate)
    {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if (name == null || name.isEmpty())
        {
            throw new IllegalArgumentException("The name can't be null or empty.");
        }

        this.name = name;
    }

    public String getSurname()
    {
        return this.surname;
    }

    public void setSurname(String surname)
    {
        if (name == null || name.isEmpty())
        {
            throw new IllegalArgumentException("The surname can't be null or empty.");
        }

        this.surname = surname;
    }

    public LocalDate getBirthdate()
    {
        return this.birthdate;
    }

    public void setBirthdate(LocalDate birthdate)
    {
        if (birthdate == null)
        {
            throw new IllegalArgumentException("The birth date can't be null.");
        }

        this.birthdate = birthdate;
    }

    public int getAge()
    {
        LocalDate today = LocalDate.now();

        return Period.between(this.birthdate, today).getYears();
    }
}
