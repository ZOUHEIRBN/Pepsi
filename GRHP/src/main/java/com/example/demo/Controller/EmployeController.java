package com.example.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Blacklist;
import com.example.demo.Entity.Departs;
import com.example.demo.Entity.Discipline;
import com.example.demo.Entity.Employe;
import com.example.demo.Services.EmployeService;
@RestController
@RequestMapping("/pepsi")
public class EmployeController {
	   
	@Autowired
	   EmployeService employeService;
	
	@GetMapping("/all")
	public List<Employe> Afficher(){
		return employeService.getAll();		
	}
	
	
	/*Collaborateur */
	
	
	@PostMapping("/ajouter")
	public Employe ajouter(@RequestBody Employe e){		
		return employeService.AddEmploye(e);		
	}
	@PutMapping("/update/{id}")
	public Employe update(@PathVariable Integer id , @RequestBody Employe e) {
		return employeService.UpdateEmploye(id, e);
	}
	@GetMapping("/All")
	public List<Employe> Afficheractive(){
		return employeService.findActived();	
	}
	@PutMapping("/delete/{id}")
	public Employe inactive(@PathVariable Integer id) {
		
		return employeService.deleteEmployerById(id);
	}
	
	@GetMapping("/FindById/{id}")
	public Employe FindById(@PathVariable Integer id) {
		
		return employeService.findCollaborateur(id);
	}
	 
	
	
	/*depart */
	
	@PostMapping("/collaborateurs/{id}/depart")
	public Departs addDepart(@PathVariable Integer id , @RequestBody Departs D) {
		
		return employeService.adddepart(D, id);
	}
	
   @GetMapping("/depart/{id}")
   public List<Departs> getdepart(@PathVariable Integer id){
	   
	   return employeService.findDepartEmploye(id);
   }
   
   @PutMapping("/updateDepart/{id}")
   public Departs updatedepart(@RequestBody Departs D , @PathVariable Integer id) {
	   
	   return employeService.UpdateDepart(D, id);
			   
   }
   
   @DeleteMapping("deletedepart/{id}")
   public void deleteDepart(@PathVariable Integer id) {
	   
	     employeService.deletedepart(id);
   }
	
	/*discipline*/
	
   @PostMapping("/collaborateurs/{idc}/addDiscipline")
	public Discipline addDisciplie(@PathVariable Integer idc , @RequestBody Discipline D) {
		
		return employeService.adddiscipline(D, idc);
	}
   
   @GetMapping("/Discipline/{id}")
   public List<Discipline> getdiscipline(@PathVariable Integer id){
	   
	   return employeService.findDisciplineEmploye(id);
   }
   
   @PutMapping("/updateDiscipline/{id}")
   public Discipline updateDiscipline(@RequestBody Discipline D , @PathVariable Integer id) {
	   
	   return employeService.UpdateDiscipline(D, id);
			   
   }
   
   @DeleteMapping("DeleteDiscipline/{id}")
   public void DeleteDiscipline(@PathVariable Integer id) {
	   
	     employeService.deletediscipline(id);
   }
   
   
   
   /*BlackList*/
   @PostMapping("/collaborateurs/{idc}/addBlackList")
	public Blacklist AddBlackList(@PathVariable Integer idc , @RequestBody Blacklist D) {
	  
		
		return employeService.addBlackList(D, idc);
	}
   
   @GetMapping("/BlackList")
   public List<Blacklist> GetBlackList(){
	   
	   return employeService.findAllBlackList();
   }

}
