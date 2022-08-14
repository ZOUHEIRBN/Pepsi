package com.example.demo.Entity;



import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.demo.Enum.Period;
import com.example.demo.Enum.Raison;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Absence {

	@Id
	@GeneratedValue
	Integer id;
	

    LocalDateTime datePremierJ,dateDernierJ,dateRetour,createdDate;
	@Enumerated(EnumType.STRING)
	Raison typeAbs;
	String responsable;
	float nombreJ;
	String commentaire;
	Period MatinorApresMidiPJ;
	Period MatinorApresMidiDJ;
	String file;
	
	@ManyToOne
	@JsonIgnore
	Collaborator collaborator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public LocalDateTime getDatePremierJ() {
        return datePremierJ;
    }

    public void setDatePremierJ(LocalDateTime datePremierJ) {
        this.datePremierJ = datePremierJ;
    }

    public LocalDateTime getDateDernierJ() {
        return dateDernierJ;
    }

    public void setDateDernierJ(LocalDateTime dateDernierJ) {
        this.dateDernierJ = dateDernierJ;
    }

    public LocalDateTime getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDateTime dateRetour) {
        this.dateRetour = dateRetour;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Raison getTypeAbs() {
        return typeAbs;
    }

    public void setTypeAbs(Raison typeAbs) {
        this.typeAbs = typeAbs;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public float getNombreJ() {
        return nombreJ;
    }

    public void setNombreJ(float nombreJ) {
        this.nombreJ = nombreJ;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Period getMatinorApresMidiPJ() {
        return MatinorApresMidiPJ;
    }

    public void setMatinorApresMidiPJ(Period matinorApresMidiPJ) {
        MatinorApresMidiPJ = matinorApresMidiPJ;
    }

    public Period getMatinorApresMidiDJ() {
        return MatinorApresMidiDJ;
    }

    public void setMatinorApresMidiDJ(Period matinorApresMidiDJ) {
        MatinorApresMidiDJ = matinorApresMidiDJ;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Collaborator getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(Collaborator collaborator) {
        this.collaborator = collaborator;
    }

	
}
