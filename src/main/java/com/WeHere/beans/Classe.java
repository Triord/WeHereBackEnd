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
@Table(name = "classe")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idClasse",
		scope = Classe.class)
public class Classe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idClasse", nullable=false)
	int idClasse ;
	
	@Column(name="annee")
	int annee;
	
	@Column(name="nomSection")
	String nomSection;
	
	@OneToMany(mappedBy = "classe",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<Utilisateur> eleveClasse;
	
	public int getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getNomSection() {
		return nomSection;
	}

	public void setNomSection(String nomSection) {
		this.nomSection = nomSection;
	}

	public Set<Utilisateur> getEleveClasse() {
		return eleveClasse;
	}

	public void setEleveClasse(Set<Utilisateur> eleveClasse) {
		this.eleveClasse = eleveClasse;
	}

	
	

	
	
	
}
