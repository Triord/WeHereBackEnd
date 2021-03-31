package com.WeHere.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.WeHere.beans.Role;
import com.WeHere.beans.Utilisateur;
import com.WeHere.repositories.RoleRepo;
import com.WeHere.repositories.UtilisateurRepo;


@RestController
public class UtilisateurController {

	@Autowired
	private UtilisateurRepo userR;
	@Autowired
	private RoleRepo roleR;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/allUser")
	public Set<Utilisateur> allUser(){
		return (Set<Utilisateur>) userR.findAllByOrder();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/UserById/{id}")
	public Utilisateur getUserWithId(@PathVariable int id) {
		Utilisateur user = userR.findById(id).get();
		return user;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/studentByClass")
	public Set<Utilisateur> allStudentByClass(@RequestParam int annee, String nomSection) {
		return userR.findallUserByClasse(annee, nomSection);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addStudent")
	public Utilisateur addStudent(@RequestBody Utilisateur student) {
		int idR = 1;
		Role role = roleR.findById(idR).get();
		student.getRole().add(role);
		userR.save(student);
		return student;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addProfessor")
	public Utilisateur addProfessor(@RequestBody Utilisateur professor) {
		int idR = 2;
		Role role = roleR.findById(idR).get();
		professor.getRole().add(role);
		userR.save(professor);
		return professor;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addEducator")
	public Utilisateur addEducator(@RequestBody Utilisateur educator) {
		int idR = 3;
		Role role = roleR.findById(idR).get();
		educator.getRole().add(role);
		userR.save(educator);
		return educator;
	}
}
