package com.WeHere.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.WeHere.beans.Utilisateur;

@Entity
@Table(name = "listeRole")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idRole")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idRole", nullable=false)
	int idRole ;
	
	@Column(name="nomRole")
	String nomRole;
	
	@ManyToMany(mappedBy = "role",fetch = FetchType.LAZY)
	private Set<Utilisateur> userFromRole = new HashSet<>();

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getNomRole() {
		return nomRole;
	}

	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}

	public Set<Utilisateur> getUserFromRole() {
		return userFromRole;
	}

	public void setUserFromRole(Set<Utilisateur> userFromRole) {
		this.userFromRole = userFromRole;
	}
	
	

}
