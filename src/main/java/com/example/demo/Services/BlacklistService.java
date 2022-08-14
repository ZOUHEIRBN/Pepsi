package com.example.demo.Services;

import java.util.List;

import com.example.demo.Entity.Blacklist;
import com.example.demo.Entity.Collaborator;
import com.example.demo.Repostory.IBlacklist;
import com.example.demo.Repostory.ICollaborator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlacklistService{
        

	@Autowired
	IBlacklist  BlackListrepository; 

    @Autowired
    ICollaborator employerepostory;

   
    public Blacklist addBlackList(Blacklist B , Integer id) {
        Collaborator c = employerepostory.getById(id);
          c.setActived(false);
          B.setEmploye(c);
         return BlackListrepository.save(B);
                
  }
    
  public List<Blacklist> findAllBlackList(){
        
    return BlackListrepository.findAll();
 }


  public Blacklist findBlackListById(Integer id) {
      return BlackListrepository.getById(id);
  }

  public List<Blacklist> findBlackListByCollaboratorCin(String cin){
    return BlackListrepository.findByCollaboratorCin(cin);
  }

public List<Blacklist> findBlacklistCollaborator(Integer id) {
  Collaborator e=employerepostory.getById(id);
  return BlackListrepository.findByCollaborator(e.getId());
}

public Blacklist UpdateBlacklist(Integer id , Blacklist e) {   
  e.setId(id);
  Blacklist B = BlackListrepository.save(e);
     return B;
}
  public Blacklist deleteBlacklistById(Integer id) {
    Blacklist e=BlackListrepository.getById(id);
    BlackListrepository.delete(e);
    return e;
  }
}