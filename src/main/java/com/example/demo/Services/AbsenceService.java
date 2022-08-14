package com.example.demo.Services;

import java.util.List;

import com.example.demo.Entity.Absence;
import com.example.demo.Entity.Collaborator;
import com.example.demo.Repostory.IAbsence;
import com.example.demo.Repostory.ICollaborator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbsenceService{
        

	@Autowired
	IAbsence  AbsenceRepository; 

    @Autowired
    ICollaborator employerepostory;

   
    public Absence addAbsence(Absence B , Integer id) {
        Collaborator c = employerepostory.getById(id);
          c.setActived(false);
          B.setCollaborator(c);
         return AbsenceRepository.save(B);
                
  }
    
  public List<Absence> findAllAbsence(){
        
    return AbsenceRepository.findAll();
 }


  public Absence findAbsenceById(Integer id) {
      return AbsenceRepository.getById(id);
  }

  public List<Absence> findAbsenceByCollaboratorCin(String cin){
    return AbsenceRepository.findByCollaboratorCin(cin);
  }

public List<Absence> findAbsenceCollaborator(Integer id) {
  Collaborator e=employerepostory.getById(id);
  return AbsenceRepository.findByCollaborator(e.getId());
}

public Absence UpdateAbsence(Integer id , Absence e) {   
  e.setId(id);
  Absence B = AbsenceRepository.save(e);
     return B;
}
  public Absence deleteAbsenceById(Integer id) {
    Absence e=AbsenceRepository.findById(id).get();
    AbsenceRepository.delete(e);
    return e;
  }
}