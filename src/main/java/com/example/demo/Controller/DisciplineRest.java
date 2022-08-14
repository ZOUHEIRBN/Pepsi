package com.example.demo.Controller;





import java.util.List;

import com.example.demo.Entity.Discipline;
import com.example.demo.Services.DisciplineService;

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
@RequestMapping("Discipline")
public class DisciplineRest {

	@Autowired
	DisciplineService service;
	
	@PostMapping("/{uid}")
	public ResponseEntity<Discipline> save(@RequestBody Discipline c, @PathVariable Integer uid)
	{
		c=service.addDiscipline(c, uid);
		if(c!=null)
		return new ResponseEntity<>(c, HttpStatus.OK);
		else
			return new ResponseEntity<Discipline>(HttpStatus.NOT_ACCEPTABLE);
	}
	

	@GetMapping("/")
	public List<Discipline> allDisciplines() {
		return service.findAllDiscipline();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Discipline> oneDiscipline(@PathVariable Integer id)
	{
		Discipline c = service.findAllDisciplineById(id);
		if(c!=null)
		return new ResponseEntity<Discipline>(c,HttpStatus.FOUND);
		else
		return new ResponseEntity<Discipline>(HttpStatus.NO_CONTENT);
		
	}

	@GetMapping("/user/{uid}")
	public List<Discipline> findByUser(@PathVariable Integer uid){
		return service.findDisciplineCollaborateur(uid);
	}

	@PutMapping("/{id}")
	public Discipline update(@PathVariable Integer id , @RequestBody Discipline e) {
		return service.UpdateDiscipline(id, e);
	}
	@DeleteMapping("/{id}")
	public Discipline delete(@PathVariable Integer id) {
		
		return service.deleteDisciplineById(id);
	}
	

}
