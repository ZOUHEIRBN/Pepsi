package com.example.demo.Repostory;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.demo.Entity.Blacklist;

@Repository
public interface IBlacklist extends JpaRepository<Blacklist, Integer>{

	List<Blacklist> findByCollaborator(Integer id);
	List<Blacklist> findByCollaboratorCin(String CIN);
	
}
