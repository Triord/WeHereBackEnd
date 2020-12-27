package com.WeHere.beans;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "cours")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idCours",
		scope = Cours.class)
public class Cours {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCours", nullable=false)
	int idCours ;
	
	@Column(name="nomCours")
	String nomCours;
		
	@OneToMany(mappedBy = "coursFp",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<FichePresence> coursDeLaFiche;
	
	@OneToMany(mappedBy = "classeFp",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<FichePresence> classeDeLaFiche;
	
	@ManyToOne(cascade = { CascadeType.MERGE },fetch = FetchType.LAZY)
	@JoinColumn(name = "idEleve", nullable = false)
	private Utilisateur eleve;
	
	@ManyToOne(cascade = { CascadeType.MERGE },fetch = FetchType.LAZY)
	@JoinColumn(name = "idUtilisateur", nullable = false)
	private Utilisateur professeur;

	public int getIdCours() {
		return idCours;
	}

	public void setIdCours(int idCours) {
		this.idCours = idCours;
	}

	public String getNomCours() {
		return nomCours;
	}

	public void setNomCours(String nomCours) {
		this.nomCours = nomCours;
	}
	
	public Utilisateur getEleve() {
		return eleve;
	}

	public void setEleve(Utilisateur eleve) {
		this.eleve = eleve;
	}

	public Utilisateur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Utilisateur professeur) {
		this.professeur = professeur;
	}

	public Set<FichePresence> getCoursDeLaFiche() {
		return coursDeLaFiche;
	}

	public void setCoursDeLaFiche(Set<FichePresence> coursDeLaFiche) {
		this.coursDeLaFiche = coursDeLaFiche;
	}

	public Set<FichePresence> getClasseDeLaFiche() {
		return classeDeLaFiche;
	}

	public void setClasseDeLaFiche(Set<FichePresence> classeDeLaFiche) {
		this.classeDeLaFiche = classeDeLaFiche;
	}


	
	
	
}
