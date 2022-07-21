package com.example.demo.Services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Blacklist;
import com.example.demo.Entity.Departs;
import com.example.demo.Entity.Discipline;
import com.example.demo.Entity.Employe;
import com.example.demo.Repostory.EmployeRepostory;
import com.example.demo.Repostory.IBlacklist;
import com.example.demo.Repostory.IDepart;
import com.example.demo.Repostory.IDiscipline;

@Service
public class EmployeService {
	@Autowired
   EmployeRepostory employerepostory;
	@Autowired
	IDepart departrepository;
	@Autowired
	IDiscipline  disciplinerepository; 
	@Autowired
	IBlacklist  BlackListrepository; 
	public List<Employe> getAll(){ 
	   return employerepostory.findAll();  
   }
   public Employe AddEmploye( Employe e) {
	   Blacklist b =BlackListrepository.findByEmployeCin(e.getCin());
	   if(b!=null) {
	    return null;
   }else {
	    e.setActived(true); 
	   return employerepostory.save(e); 
	   }
	   }
	   
   public Employe UpdateEmploye(Integer id , Employe e) {   
	   e.setId(id);
	    Employe C = employerepostory.save(e);
	      return C;
   }
   public List<Employe> findActived() {	
		return employerepostory.findEmployeeByactived(true);
	}
   
	public Employe findCollaborateur(Integer id) {
		
		Optional<Employe> o = employerepostory.findById(id);
		if(o.isPresent())
		return o.get();
		else
			return null;
		
	}
   
   public Employe deleteEmployerById(Integer id) {
		Employe e=employerepostory.getById(id);
		e.setActived(false);
		
	    return	employerepostory.save(e);
	}
   
   
 	public Departs adddepart(Departs D, Integer idc) {
 		
 		Employe c =employerepostory.getById(idc);
 		D.setCollaborateur(c);
 		 departrepository.save(D);
 		return D;
 		
 	}
 	
 	 
 	public List<Departs> findDepartEmploye(Integer id){
 		  Employe e=employerepostory.getById(id);
 		  return departrepository.findByCollaborateur(e);
 	}
 	
 	public Departs UpdateDepart(Departs d , Integer id) {
 		
 		Departs e =departrepository.getById(id);
 		   e.setId(id);
 		   e.setDatededepart(d.getDatededepart());
 	       e.setDatefindepaie(d.getDatefindepaie());	
	       e.setDernierjourtravaille(d.getDernierjourtravaille());
	       e.setMotif(d.getMotif());
	      return departrepository.save(e);
 	}
 	
 	public void deletedepart(Integer id) {
 		
 		departrepository.deleteById(id);
 		
 	}
 	
 	
 	public Discipline adddiscipline(Discipline D, Integer idc) {
 		
 		Employe c =employerepostory.getById(idc);
 		D.setCollaborateur(c);
 		 disciplinerepository.save(D);
 		return D;
 		
 	}
   
 	public List<Discipline> findDisciplineEmploye(Integer id){
		  Employe e=employerepostory.getById(id);
		  return disciplinerepository.findByCollaborateur(e);
	}
   
	public Discipline UpdateDiscipline(Discipline c , Integer id) {
 		Discipline d=disciplinerepository.getById(id);
 		d.setAvertissement(d.getAvertissement());
 		d.setDate(c.getDate());
 		d.setFile(c.getFile());
 		d.setId(id);
 		
 		
	    Discipline D = disciplinerepository.save(d);
	      return D;	
	}
	
      public void deletediscipline(Integer id) {
 		
 		disciplinerepository.deleteById(id);
 		
 	}
      
      public Blacklist addBlackList(Blacklist B , Integer id) {
		  Employe c = employerepostory.getById(id);
		    c.setActived(false);
		    B.setEmploye(c);
		   return BlackListrepository.save(B);
		    	  
	}
      
      public List<Blacklist> findAllBlackList(){
    	  
    	 return BlackListrepository.findAll();
      }
   
}
