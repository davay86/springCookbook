package com.springcookbook.domain;

import javax.persistence.*;
import java.util.LinkedList;

/**
 * Created by davidronaldson on 09/12/2016.
 */
public class User {
    private Long id;
    private String firstName;
    private Integer age;

    public LinkedList<Post> getPosts() {
        return posts;
    }

    public void setPosts(LinkedList<Post> posts) {
        this.posts = posts;
    }

    private LinkedList<Post> posts = new LinkedList<Post>();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

}
