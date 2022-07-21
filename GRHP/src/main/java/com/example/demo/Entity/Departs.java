
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
	Employe collaborateur;
}
