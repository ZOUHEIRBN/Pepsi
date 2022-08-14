package com.example.demo.Services;

import java.util.List;
import com.example.demo.Entity.Discipline;
import com.example.demo.Entity.Collaborator;
import com.example.demo.Repostory.IDiscipline;
import com.example.demo.Repostory.ICollaborator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplineService {

    @Autowired
   ICollaborator employerepostory;
    @Autowired
	IDiscipline  disciplinerepository; 

    public Discipline addDiscipline(Discipline D, Integer idc) {
 		
        Collaborator c =employerepostory.getById(idc);
        D.setCollaborateur(c);
         disciplinerepository.save(D);
        return D;
        
    }
  
    public List<Discipline> findDisciplineCollaborateur(Integer id){
        Collaborator e=employerepostory.getById(id);
        return disciplinerepository.findByCollaborateur(e);
  }
    
  public List<Discipline> findAllDiscipline(){
    return disciplinerepository.findAll();
}

    public Discipline findAllDisciplineById(Integer id){
        return disciplinerepository.getById(id);
    }

    public Discipline UpdateDiscipline(Integer id, Discipline c ) {
        Discipline d=disciplinerepository.getById(id);
        d.setAvertissement(d.getAvertissement());
        d.setDate(c.getDate());
        d.setFile(c.getFile());
        d.setId(id);
        
        
       Discipline D = disciplinerepository.save(d);
         return D;	
   }
   
   public Discipline deleteDisciplineById(Integer id) {
    Discipline e = disciplinerepository.getById(id);
    disciplinerepository.delete(e);
        return e;
    }
}
