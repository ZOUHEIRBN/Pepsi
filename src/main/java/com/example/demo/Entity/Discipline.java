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
public class Discipline {

	@Id
	@GeneratedValue
	Integer id;
	String avertissement;
	LocalDate date;
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
	public String getAvertissement() {
		return avertissement;
	}
	public void setAvertissement(String avertissement) {
		this.avertissement = avertissement;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public Collaborator getCollaborateur() {
		return collaborateur;
	}
	public void setCollaborateur(Collaborator collaborateur) {
		this.collaborateur = collaborateur;
	}
	String file;
	@JsonIgnore
	@ManyToOne
	Collaborator collaborateur;
}
