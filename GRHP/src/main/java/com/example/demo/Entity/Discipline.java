package com.example.demo.Entity;

import java.time.LocalDate; 

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	String file;
	@JsonIgnore
	@ManyToOne
	Employe collaborateur;
}
