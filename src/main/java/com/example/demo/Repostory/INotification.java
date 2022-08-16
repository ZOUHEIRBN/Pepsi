package com.example.demo.Repostory;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.demo.Entity.Notification;

@Repository
public interface INotification extends JpaRepository<Notification, Long>{

	List<Notification> findByUser(Long id);
	
}
