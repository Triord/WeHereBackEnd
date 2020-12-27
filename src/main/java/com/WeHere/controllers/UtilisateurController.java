package com.WeHere.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.WeHere.beans.Utilisateur;
import com.WeHere.repositories.UtilisateurRepo;


@RestController
public class UtilisateurController {

	@Autowired
	private UtilisateurRepo userR;
	
	@GetMapping(value="/allUser")
	public Set<Utilisateur> allUser(){
		return (Set<Utilisateur>) userR.findAllByOrder();
	}
	@GetMapping("/UserById/{id}")
	public Utilisateur getUserWithId(@PathVariable int id) {
		Utilisateur user = userR.findById(id).get();
		return user;
	}
	@GetMapping("/studentByClass")
	public Set<Utilisateur> allStudentByClass(@RequestParam int annee, String nomSection) {
		return userR.findallUserByClasse(annee, nomSection);
	}
}
