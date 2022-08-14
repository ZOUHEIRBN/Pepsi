
package com.example.demo.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data 
public class Departs {

	@Id
	@GeneratedValue
	Integer id;
	String motif;
	LocalDate datededepart;
	LocalDate dernierjourtravaille;
	LocalDate datefindepaie;
	@JsonIgnore
	@ManyToOne
	Collaborator collaborator;
	public Collaborator getCollaborator() {
		return collaborator;
	}
	public void setCollaborator(Collaborator collaborator) {
		this.collaborator = collaborator;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public LocalDate getDatededepart() {
		return datededepart;
	}
	public void setDatededepart(LocalDate datededepart) {
		this.datededepart = datededepart;
	}
	public LocalDate getDernierjourtravaille() {
		return dernierjourtravaille;
	}
	public void setDernierjourtravaille(LocalDate dernierjourtravaille) {
		this.dernierjourtravaille = dernierjourtravaille;
	}
	public LocalDate getDatefindepaie() {
		return datefindepaie;
	}
	public void setDatefindepaie(LocalDate datefindepaie) {
		this.datefindepaie = datefindepaie;
	}

}
