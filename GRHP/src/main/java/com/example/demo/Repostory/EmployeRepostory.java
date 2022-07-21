package com.example.demo.Repostory;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Employe;


@Repository
public interface EmployeRepostory extends JpaRepository<Employe, Integer>{

	  List<Employe> findEmployeeByactived(boolean a);
 
	
}
