package com.example.demo.Services;

import java.util.List;

import com.example.demo.Entity.Notification;
import com.example.demo.Repostory.INotification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final SimpMessagingTemplate messagingTemplate;
    
    @Autowired
    INotification notificationrepo;
    
    @Autowired
    public NotificationService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }
    public String sendGlobalNotification(String title, String content) {
        Notification message = new Notification(title, content);
        messagingTemplate.convertAndSend("/pepsi_rh/notification",message);
        return message.getContent();
    }
    public void sendPrivateNotification(final String userId, String title, String content) {
        Notification message = new Notification(title, content);
        messagingTemplate.convertAndSendToUser(userId,"/pepsi_rh/notification",message);
    }
    public List<Notification> getAllByUser(Long id) {
        return notificationrepo.findByUser(id);
    }
}