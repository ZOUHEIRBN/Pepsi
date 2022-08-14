package com.example.demo.Controller;





import java.util.List;

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

import com.example.demo.Entity.Absence;
import com.example.demo.Services.AbsenceService;

@CrossOrigin(origins = "*", allowedHeaders = "*") //DESKTOP-8CM1NR0:4200
@RestController
@RequestMapping("Absence")
public class AbsenceRest {

	@Autowired
	AbsenceService service;
	


	@GetMapping("/")
	public List<Absence> allAbsence() {
		return service.findAllAbsence();
	}

	@GetMapping("/{id}")
	public Absence oneBlacklist(@PathVariable Integer id) {
		return service.findAbsenceById(id);
	}

	@GetMapping("/user/{id}")
	public List<Absence> findByUser(@PathVariable Integer id){
		return service.findAbsenceCollaborator(id);

	}
	

	
	
	@PostMapping("/{id}")
	public Absence addabss(@RequestBody Absence ab,@PathVariable Integer id)
	{
		
		return service.addAbsence(ab, id);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAbsence(@PathVariable("id") Integer id)
	{
		if(service.findAbsenceById(id)!=null)
		{
			service.deleteAbsenceById(id);
			return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Absence> updateAbsences(@RequestBody Absence abs,@PathVariable Integer id) {
		if(service.findAbsenceById(id)!=null)
		{
			abs=service.UpdateAbsence(id, abs);
			return new ResponseEntity<Absence>(abs,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

                
	
	
	
	
	
}
