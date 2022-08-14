package com.example.demo.Services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Blacklist;

import com.example.demo.Entity.Collaborator;
import com.example.demo.Repostory.ICollaborator;
import com.example.demo.Repostory.IBlacklist;


@Service
public class CollaboratorService {
	@Autowired
   ICollaborator employerepostory;
	
	
	@Autowired
	IBlacklist  BlackListrepository; 
	public List<Collaborator> getAll(){ 
		
	   return employerepostory.findAll();  
   }
   public Collaborator AddCollaborator(Collaborator e) {
	   List<Blacklist> b =BlackListrepository.findByCollaboratorCin(e.getCin());
	   if(b.size() > 0) {
			return null;
		}else {
			e.setActived(true); 
			return employerepostory.save(e); 
	   	}
	   }
	   
   public Collaborator UpdateEmploye(Integer id , Collaborator e) {   
	   e.setId(id);
	    Collaborator C = employerepostory.save(e);
	      return C;
   }
   public List<Collaborator> findActived() {	
		return employerepostory.findEmployeeByactived(true);
	}
   
	public Collaborator findCollaborateur(Integer id) {
		
		Optional<Collaborator> o = employerepostory.findById(id);
		if(o.isPresent())
		return o.get();
		else
			return null;
		
	}
   
   public Collaborator deleteEmployerById(Integer id) {
		Collaborator e=employerepostory.getById(id);
		e.setActived(false);
		
	    return	employerepostory.save(e);
	}
   
   
 	
 	
 	
   
}
