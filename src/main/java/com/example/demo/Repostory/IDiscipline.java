package com.example.demo.Repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Discipline;
import com.example.demo.Entity.Collaborator; 

@Repository
public interface IDiscipline extends JpaRepository<Discipline, Integer>{
  
	public List<Discipline> findByCollaborateur(Collaborator collaborateur);
	
	
}
