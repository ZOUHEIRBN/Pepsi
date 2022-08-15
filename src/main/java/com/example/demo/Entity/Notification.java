package com.example.demo.Entity;

import java.util.Date;



public class Notification {
    private String content;
    private String title;
    private final Date timestamp = new Date();
    private Long receiverId;


    public Notification(String content) {
        this.content = content;
    }

    public Notification(String title, String content) {
        this.content = content;
        this.title = title;
    }

    public Notification(String content, String title, Long receiverId) {
        this.content = content;
        this.title = title;
        this.receiverId = receiverId;
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

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }
}