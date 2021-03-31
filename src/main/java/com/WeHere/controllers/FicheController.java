package com.WeHere.controllers;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.WeHere.beans.FichePresence;
import com.WeHere.beans.Utilisateur;
import com.WeHere.repositories.FicheRepo;
import com.WeHere.repositories.UtilisateurRepo;
import com.WeHere.services.FicheImpl;
import com.WeHere.jwt.JwtUserDetails;

@RestController
public class FicheController {

	@Autowired
	private FicheImpl ficheS;
	@Autowired
	private FicheRepo ficheR;
	@Autowired
	private UtilisateurRepo userR;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/test")
	public FichePresence test(FichePresence fp) {
		return ficheS.addFiche(fp);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/ficheByParams")
	public Set<FichePresence> allFicheByParams(@RequestParam String heureCours, int annee, String nomSection, String nomCours, String dateJourPresence) {
		return ficheR.findallFicheByParams(heureCours, annee, nomSection, nomCours, dateJourPresence);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/ficheForVerif")
	public Set<FichePresence> allFicheForVerif(@RequestParam String heureCours, int annee, String nomSection, String nomCours) {
		return ficheR.findallFicheForVerif(heureCours, annee, nomSection, nomCours);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/ficheById/{id}")
	public FichePresence getFicheWithId(@PathVariable int id) {
		FichePresence fp = ficheR.findById(id).get();
		return fp;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/testAddFiche")
	public FichePresence addAllFP(@RequestBody FichePresence fp) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int idEmpModif = ((JwtUserDetails)principal).getId();
		Utilisateur prof = new Utilisateur();
		prof = userR.findById(idEmpModif).get();
		Date dayDate = new Date();
		
		fp.setProfesseurFp(prof);
		fp.setDateJourPresence(dayDate);
		ficheR.save(fp);
		return fp;
	}
}
