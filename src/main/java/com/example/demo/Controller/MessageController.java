package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.security.Principal;

import com.example.demo.Entity.Message;
import com.example.demo.Entity.Notification;
import com.example.demo.Services.NotificationService;

@Controller
public class MessageController {
    @Autowired
    private NotificationService notificationService;



    @MessageMapping("/message")
    @SendTo("/pepsi_rh/messages")
public Notification getMessage(final Message message) throws InterruptedException {
     Thread.sleep(1000);
     notificationService.sendGlobalNotification("Message", message.getMessageContent());
     return new Notification(HtmlUtils.htmlEscape(message.getMessageContent()));
}

    @MessageMapping("/private-message")
    @SendToUser("/pepsi_rh/private-messages")
    public Notification getPrivateMessage(final Message message, final Principal principal) throws InterruptedException {
        Thread.sleep(1000);
        notificationService.sendPrivateNotification(principal.getName(), "Message", message.getMessageContent());
        return new Notification(HtmlUtils.htmlEscape("Sending Private message to User"  + principal.getName() + " : " + message.getMessageContent()));
    }
}