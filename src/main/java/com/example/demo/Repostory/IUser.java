package com.example.demo.Repostory;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;

@Repository
public interface IUser extends JpaRepository<User, Long>{
	
}
