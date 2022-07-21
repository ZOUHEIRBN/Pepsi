package com.example.demo.Entity;

import java.sql.Date; 
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Data
public class Employe {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
    private String  nom;
    private String prenom;
    private String email;
    private String prenom2;
    private String sexe;
    private String genre;
    private String situation;
    private Date date_naiss;
    private String lieu_naiss;
    private String pays;
    private String ville;
    private String nationalite;
    private String langue;
    private String adress;
    private int tel;
    @Column(unique = true)
    private String cin;
    private String id_ass;
    private String id_sec;
    private Date hiredate;
    private String poste;
    private String motif;
     @Column
     boolean actived ;
    
 	@OneToMany(mappedBy = "collaborateur")
 	List<Discipline> disciplines=new ArrayList<>();
 	 	
 	
 	@OneToMany(mappedBy = "collaborateur")
 	List<Departs> depart=new ArrayList<Departs>();
 	
 	@OneToMany(mappedBy = "employe")
 	List<Blacklist> blacklists=new ArrayList<Blacklist>();
	
	
}
