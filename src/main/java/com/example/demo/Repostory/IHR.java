package com.example.demo.Repostory;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.HR;

@Repository
public interface IHR extends JpaRepository<HR, Long>{
	HR findByUsername(String email);
}
