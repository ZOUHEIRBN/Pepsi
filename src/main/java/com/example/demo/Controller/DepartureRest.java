package com.example.demo.Controller;





import java.util.List;

import com.example.demo.Entity.Departs;
import com.example.demo.Services.DepartService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*", allowedHeaders = "*") //DESKTOP-8CM1NR0:4200
@RestController
@RequestMapping("Depart")
public class DepartureRest {

	@Autowired
	DepartService service;
	
	@PostMapping("/{uid}")
	public ResponseEntity<Departs> save(@RequestBody Departs c, @PathVariable Integer uid)
	{
		c=service.addDepart(c, uid);
		if(c!=null)
		return new ResponseEntity<>(c, HttpStatus.OK);
		else
			return new ResponseEntity<Departs>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping("/")
	public List<Departs> allDepartss() {
		return service.findAllDeparts();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Departs> oneDeparts(@PathVariable Integer id)
	{
		Departs c = service.findDepartById(id);
		if(c!=null)
		return new ResponseEntity<Departs>(c,HttpStatus.FOUND);
		else
		return new ResponseEntity<Departs>(HttpStatus.NO_CONTENT);
		
	}

	@GetMapping("/user/{uid}")
	public List<Departs> findByUser(@PathVariable Integer uid){
		return service.findDepartCollaborator(uid);
	} 
	
	@PutMapping("/{id}")
	public Departs update(@PathVariable Integer id , @RequestBody Departs e) {
		return service.UpdateDepart(id, e);
	}
	@DeleteMapping("/{id}")
	public Departs delete(@PathVariable Integer id) {
		
		return service.deleteDepartById(id);
	}

}
