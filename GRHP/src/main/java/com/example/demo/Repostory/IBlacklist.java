package com.example.demo.Repostory;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Blacklist;

@Repository
public interface IBlacklist extends JpaRepository<Blacklist, Long>{

	Blacklist findByEmployeCin(String CIN);
	
}
