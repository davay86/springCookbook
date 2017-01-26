package com.springcookbook.domain;

/**
 * Created by davidronaldson on 11/01/2017.
 */
public class User {

    private String name;
    private int age;
    private boolean married;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }
}
