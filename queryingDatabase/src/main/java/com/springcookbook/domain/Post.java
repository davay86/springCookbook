package com.springcookbook.domain;

import java.util.Date;

/**
 * Created by davidronaldson on 20/12/2016.
 */
public class Post {
    private long id;
    private String title;
    private Date date;
    private User user;

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
