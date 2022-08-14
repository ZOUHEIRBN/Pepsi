package com.example.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Collaborator;
import com.example.demo.Entity.Notification;
import com.example.demo.Services.CollaboratorService;
@CrossOrigin(origins = "*", allowedHeaders = "*") //DESKTOP-8CM1NR0:4200
@RestController
@RequestMapping("Collaborator")
public class CollaboratorRest {
	   
	@Autowired
	CollaboratorService employeService;

	@GetMapping("/")
	public List<Collaborator> Afficher(){
		Notification n = new Notification("title", "text");
  		n.send();
		return employeService.getAll();		
	}
	
	@PostMapping("/")
	public Collaborator ajouter(@RequestBody Collaborator e){		
		return employeService.AddCollaborator(e);		
	}
	@PutMapping("/{id}")
	public Collaborator update(@PathVariable Integer id , @RequestBody Collaborator e) {
		return employeService.UpdateEmploye(id, e);
	}
	
	
	@GetMapping("/active")
	public List<Collaborator> Afficheractive(){
		Notification n = new Notification("title", "text");
  		n.send();
		return employeService.findActived();	
	}
	@DeleteMapping("/{id}")
	public Collaborator inactive(@PathVariable Integer id) {
		
		return employeService.deleteEmployerById(id);
	}
	
	@GetMapping("/{id}")
	public Collaborator FindById(@PathVariable Integer id) {
		
		return employeService.findCollaborateur(id);
	}
	 

}
