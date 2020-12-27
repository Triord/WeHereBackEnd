package com.WeHere.beans;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "fichePresence")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idFichePresence",
		scope = FichePresence.class)
public class FichePresence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idFichePresence", nullable=false)
	int idFichePresence ;
	
	@Column(name="statusPresence")
	String statusPresence;
	
	@Column(name="statusSupplementaire")
	String statusSupplementaire;
	
	@Column(name="dateJourPresence")
	Date dateJourPresence;
	
	@Column(name="heureCours")
	Time heureCours;
	
	@Column(name="raison")
	String raison;
	
	@ManyToOne(cascade = { CascadeType.MERGE },fetch = FetchType.LAZY)
	@JoinColumn(name = "idEleve", nullable = false)
	private Utilisateur eleveFp;
	
	@ManyToOne(cascade = { CascadeType.MERGE },fetch = FetchType.LAZY)
	@JoinColumn(name = "idProf", nullable = false)
	private Utilisateur professeurFp;
	
	@ManyToOne(cascade = { CascadeType.MERGE },fetch = FetchType.LAZY)
	@JoinColumn(name = "idClasse", nullable = false)
	private Classe classeFp ;
	
	@ManyToOne(cascade = { CascadeType.MERGE },fetch = FetchType.LAZY)
	@JoinColumn(name = "idCours", nullable = false)
	private Cours coursFp;

	public int getIdFichePresence() {
		return idFichePresence;
	}

	public void setIdFichePresence(int idFichePresence) {
		this.idFichePresence = idFichePresence;
	}

	public String getStatusPresence() {
		return statusPresence;
	}

	public void setStatusPresence(String statusPresence) {
		this.statusPresence = statusPresence;
	}

	public String getStatusSupplementaire() {
		return statusSupplementaire;
	}

	public void setStatusSupplementaire(String statusSupplementaire) {
		this.statusSupplementaire = statusSupplementaire;
	}

	public Date getDateJourPresence() {
		return dateJourPresence;
	}

	public void setDateJourPresence(Date dateJourPresence) {
		this.dateJourPresence = dateJourPresence;
	}

	public Time getHeureCours() {
		return heureCours;
	}

	public void setHeureCours(Time heureCours) {
		this.heureCours = heureCours;
	}

	public Utilisateur getEleveFp() {
		return eleveFp;
	}

	public void setEleveFp(Utilisateur eleveFp) {
		this.eleveFp = eleveFp;
	}

	public Utilisateur getProfesseurFp() {
		return professeurFp;
	}

	public void setProfesseurFp(Utilisateur professeurFp) {
		this.professeurFp = professeurFp;
	}

	public Classe getClasseFp() {
		return classeFp;
	}

	public void setClasseFp(Classe classeFp) {
		this.classeFp = classeFp;
	}

	public Cours getCoursFp() {
		return coursFp;
	}

	public void setCoursFp(Cours coursFp) {
		this.coursFp = coursFp;
	}

	public String getRaison() {
		return raison;
	}

	public void setRaison(String raison) {
		this.raison = raison;
	}

	
	
	

}
