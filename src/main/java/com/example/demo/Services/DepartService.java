package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Entity.Departs;
import com.example.demo.Entity.Collaborator;
import com.example.demo.Repostory.ICollaborator;
import com.example.demo.Repostory.IDepart;


@Service
public class DepartService {
    @Autowired
   ICollaborator employerepostory;
	@Autowired
	IDepart departrepository;


    public Departs addDepart(Departs D, Integer idc) {
 		
        Collaborator c =employerepostory.getById(idc);
        D.setCollaborator(c);
         departrepository.save(D);
        return D;
        
    }
    
     
    public List<Departs> findDepartCollaborator(Integer id){
          Collaborator e=employerepostory.getById(id);
          return departrepository.findByCollaborator(e);
    }


    public List<Departs> findAllDeparts(){
        return departrepository.findAll();
    }
    
    public Departs findDepartById(Integer id){
        return departrepository.getById(id);
    }
    
    public Departs UpdateDepart(Integer id, Departs d) {
        
        Departs e =departrepository.getById(id);
        e.setId(id);
        e.setDatededepart(d.getDatededepart());
        e.setDatefindepaie(d.getDatefindepaie());	
        e.setDernierjourtravaille(d.getDernierjourtravaille());
        e.setMotif(d.getMotif());
        return departrepository.save(e);
    }
    
    public Departs deleteDepartById(Integer id) {
        Departs e = departrepository.getById(id);
        departrepository.delete(e);
        return e;
    }
}
