package com.example.demo.Repostory;

import java.util.List;

import com.example.demo.Entity.Absence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;



@CrossOrigin
public interface IAbsence extends JpaRepository<Absence, Integer>{
    List<Absence> findByCollaborator(Integer id);
	List<Absence> findByCollaboratorCin(String CIN);
}
