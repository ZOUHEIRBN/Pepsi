package com.example.demo.Entity;

import java.util.Date;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class Notification {

    private String title;
    private String text;
    private String url;
    private Date timestamp;
    private static SimpMessagingTemplate template = new SimpMessagingTemplate(new MessageChannel() {

        @Override
        public boolean send(Message<?> message, long timeout) {
            System.out.println(timeout);
            return true;
        }
        
    });;

    public Notification(String title, String text) {
        this.title = title;
        this.text = text;
        this.setTimestamp(new Date());
    }

    public Notification(String title, String text, String url) {
        this.title = title;
        this.text = text;
        this.url = url;
        this.setTimestamp(new Date());
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
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }


    public void send(){
		// Push notifications to front-end		
		Notification notification = new Notification("Test notification", 
		"Lorem ipsum dolor sit amet");
        template.convertAndSend("/pepsi_rh/notification", notification);

	}
}