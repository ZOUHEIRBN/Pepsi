/**
 * 
 */
package com.example.demo.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * @author BENLAHMAR EL HABIB
 */
@Entity
@Data
public class Blacklist {

	@Id
	@GeneratedValue
	long id;
	String motif;
	LocalDate date;
	@JsonIgnore
	@ManyToOne
	Collaborator collaborator;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Collaborator getEmploye() {
		return collaborator;
	}
	public void setEmploye(Collaborator employe) {
		this.collaborator = employe;
	}
	
}
