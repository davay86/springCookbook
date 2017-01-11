package com.springcookbook.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by davidronaldson on 10/01/2017.
 */
public class User {

    @NotEmpty
    private String firstname;
    @Min(3)
    @Max(10)
    private int age;
    private String country;
    private boolean married;

    public User(String firstname, int age, String country, boolean married) {
        this.firstname = firstname;
        this.age = age;
        this.country = country;
        this.married = married;
    }

    public User() {

    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
