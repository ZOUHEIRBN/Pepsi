package com.example.demo.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String content;
    @Column
    private String title;
    @Column
    private final Date timestamp = new Date();
    @ManyToOne
    @JsonIgnore
    private User user;


    public Notification(String content) {
        this.content = content;
    }

    public Notification(String title, String content) {
        this.content = content;
        this.title = title;
    }

    public Notification(String content, String title, User receiver) {
        this.content = content;
        this.title = title;
        this.user = receiver;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getReceiver() {
        return user;
    }

    public void setReceiverId(User receiver) {
        this.user = receiver;
    }
}