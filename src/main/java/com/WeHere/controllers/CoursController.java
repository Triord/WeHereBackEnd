package com.WeHere.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.WeHere.beans.Cours;
import com.WeHere.repositories.CoursRepo;

@RestController
public class CoursController {

	@Autowired
	private CoursRepo coursR;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/allCours")
	public List<Cours> getAllCours(){
		List<Cours> cours = (List<Cours>) coursR.findAll();
		return cours;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/courById/{id}")
	public Cours courById(@PathVariable int id){
		Cours cour =  coursR.findById(id).get();
		return cour;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/courByParam")
	public Cours courByName(@RequestParam String nomCours) {
		return coursR.findCourByName(nomCours);
	}
	
	
}
