package com.example.demo.Controller;

import java.util.List;

import com.example.demo.Entity.Notification;
import com.example.demo.Services.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*") //DESKTOP-8CM1NR0:4200
@RestController
@RequestMapping("Blacklist")
public class NotificationRest {
    @Autowired
    NotificationService notificationservice;

    @GetMapping("/{user_id}")
    public List<Notification> getAllByUser(@RequestParam Long user_id){
        return notificationservice.getAllByUser(user_id);
    }
}
