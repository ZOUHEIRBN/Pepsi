package com.example.demo.Entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Collaborator {
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
    
 	@OneToMany(mappedBy = "collaborator")
 	List<Discipline> disciplines=new ArrayList<>();
 	 	
 	
 	@OneToMany(mappedBy = "collaborator")
 	List<Departs> depart=new ArrayList<Departs>();
 	
 	@OneToMany(mappedBy = "collaborator")
 	List<Blacklist> blacklists=new ArrayList<Blacklist>();

     
 	@OneToMany(mappedBy = "collaborator")
 	List<Absence> absences=new ArrayList<Absence>();

    public List<Absence> getAbsences() {
        return absences;
    }

    public void setAbsences(List<Absence> absences) {
        this.absences = absences;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenom2() {
        return prenom2;
    }

    public void setPrenom2(String prenom2) {
        this.prenom2 = prenom2;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public Date getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(Date date_naiss) {
        this.date_naiss = date_naiss;
    }

    public String getLieu_naiss() {
        return lieu_naiss;
    }

    public void setLieu_naiss(String lieu_naiss) {
        this.lieu_naiss = lieu_naiss;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getId_ass() {
        return id_ass;
    }

    public void setId_ass(String id_ass) {
        this.id_ass = id_ass;
    }

    public String getId_sec() {
        return id_sec;
    }

    public void setId_sec(String id_sec) {
        this.id_sec = id_sec;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public boolean isActived() {
        return actived;
    }

    public void setActived(boolean actived) {
        this.actived = actived;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public List<Departs> getDepart() {
        return depart;
    }

    public void setDepart(List<Departs> depart) {
        this.depart = depart;
    }

    public List<Blacklist> getBlacklists() {
        return blacklists;
    }

    public void setBlacklists(List<Blacklist> blacklists) {
        this.blacklists = blacklists;
    }
	
	
}
