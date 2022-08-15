package com.example.demo.Services;


import com.example.demo.Entity.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WSService {
    private final SimpMessagingTemplate messagingTemplate;
    private final NotificationService notificationService;
    @Autowired
    public WSService(SimpMessagingTemplate messagingTemplate, NotificationService notificationService) {
        this.messagingTemplate = messagingTemplate;
        this.notificationService = notificationService;
    }
    public void NotifyFrontend(final String message) {
        Notification response = new Notification(message);
        notificationService.sendGlobalNotification("Notification", message);

        messagingTemplate.convertAndSend("/pepsi_rh/messages",response);

    }
    public void NotifyUser(final String id , final String message) {
        Notification response = new Notification(message);
        notificationService.sendPrivateNotification(id, "Notification", message);
        messagingTemplate.convertAndSendToUser(id,"/pepsi_rh/private-messages",response);

    }
}
