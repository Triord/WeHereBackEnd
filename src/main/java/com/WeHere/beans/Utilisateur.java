package com.WeHere.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.WeHere.services.Password;
import com.WeHere.beans.Role;

@Entity
@Table(name = "utilisateur")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idUtilisateur")
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idUtilisateur", nullable=false)
	int idUtilisateur ;
	
	@Column(name="nom")
	String nom;
	
	@Column(name="prenom")
	String prenom;
	
	@Column(name="ddn")
	Date ddn;
	
	@Column(name="adresse")
	String adresse;
	
	@Column(name="numTel")
	String numTel;
	
	@Column(name="email")
	String email;
	
	@Column(name="mdp")
	String mdp;

	@OneToMany(mappedBy = "eleve",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<Cours> coursRecu;
	
	@OneToMany(mappedBy = "professeur",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<Cours> coursDonner;
	
	@OneToMany(mappedBy = "eleveFp",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<FichePresence> presenceEleve;
	
	@OneToMany(mappedBy = "professeurFp",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<FichePresence> profDeLaFiche;
	
	
	@ManyToOne(cascade = { CascadeType.MERGE },fetch = FetchType.LAZY)
	@JoinColumn(name = "idClasse")
	private Classe classe;
	
	@ManyToMany(cascade = { CascadeType.MERGE },fetch = FetchType.EAGER)
    @JoinTable(
	        name = "roleUtilisateur", 
	        joinColumns = { @JoinColumn(name = "idUtilisateur") }, 
	        inverseJoinColumns = { @JoinColumn(name = "idRole") }
	    )
	private Set<Role> role = new HashSet<>();
	
	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
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

	public Date getDdn() {
		return ddn;
	}

	public void setDdn(Date ddn) {
		this.ddn = ddn;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public Set<Cours> getCoursRecu() {
		return coursRecu;
	}

	public void setCoursRecu(Set<Cours> coursRecu) {
		this.coursRecu = coursRecu;
	}

	public Set<Cours> getCoursDonner() {
		return coursDonner;
	}

	public void setCoursDonner(Set<Cours> coursDonner) {
		this.coursDonner = coursDonner;
	}

	public Set<FichePresence> getPresenceEleve() {
		return presenceEleve;
	}

	public void setPresenceEleve(Set<FichePresence> presenceEleve) {
		this.presenceEleve = presenceEleve;
	}

	public Set<FichePresence> getProfDeLaFiche() {
		return profDeLaFiche;
	}

	public void setProfDeLaFiche(Set<FichePresence> profDeLaFiche) {
		this.profDeLaFiche = profDeLaFiche;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		Password p = new Password(mdp);
		p.firstHash();
		System.out.println(p.getHash());
		return mdp;
	}

	public void setMdp(String mdp) {
		Password p = new Password(mdp);
		p.firstHash();
		this.mdp = p.getHash();
	}
	


	
	
	
	

}
