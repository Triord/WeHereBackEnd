package com.WeHere.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.WeHere.beans.Classe;
import com.WeHere.repositories.ClasseRepo;



@RestController
public class ClasseController {

	@Autowired
	private ClasseRepo classeR;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/classeById/{id}")
	public Classe getClasseWithId(@PathVariable int id) {
		Classe classe = classeR.findById(id).get();
		return classe;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("getAllClasse")
	public List<Classe> allClasse(){
		return (List<Classe>) classeR.findAll();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/classeByParams")
	public Classe classeByYearsAndName(@RequestParam int annee, String nomSection) {
		return classeR.findClasseByYearsAndName(annee, nomSection);
	}
}
