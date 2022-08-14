package com.example.demo.Controller;





import java.util.List;

import com.example.demo.Entity.Blacklist;
import com.example.demo.Services.BlacklistService;

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
@RequestMapping("Blacklist")
public class BlacklistRest {

	@Autowired
	BlacklistService service;
	
	@PostMapping("/{uid}")
	public ResponseEntity<Blacklist> save(@RequestBody Blacklist c, @PathVariable Integer uid)
	{
		c=service.addBlackList(c, uid);
		if(c!=null)
		return new ResponseEntity<>(c, HttpStatus.OK);
		else
			return new ResponseEntity<Blacklist>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping("/")
	public List<Blacklist> allBlacklists() {
		return service.findAllBlackList();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Blacklist> oneBlacklist(@PathVariable Integer id)
	{
		Blacklist c = service.findBlackListById(id);
		if(c!=null)
		return new ResponseEntity<Blacklist>(c,HttpStatus.FOUND);
		else
		return new ResponseEntity<Blacklist>(HttpStatus.NO_CONTENT);
		
	}

	@GetMapping("/user/{id}")
	public List<Blacklist> findByUser(@PathVariable Integer id){
		return service.findBlacklistCollaborator(id);

	}
	
	@PutMapping("/{id}")
	public Blacklist update(@PathVariable Integer id , @RequestBody Blacklist e) {
		return service.UpdateBlacklist(id, e);
	}
	@DeleteMapping("/{id}")
	public Blacklist delete(@PathVariable Integer id) {
		
		return service.deleteBlacklistById(id);
	}
	
}
