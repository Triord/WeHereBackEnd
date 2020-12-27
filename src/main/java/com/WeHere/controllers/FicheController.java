package com.WeHere.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.WeHere.beans.FichePresence;
import com.WeHere.repositories.FicheRepo;
import com.WeHere.services.FicheImpl;

@RestController
public class FicheController {

	@Autowired
	private FicheImpl ficheS;
	@Autowired
	private FicheRepo ficheR;
	
	@GetMapping(value="/test")
	public FichePresence test(/*add requestbody*/FichePresence fp) {
		return ficheS.addFiche(fp);
	}
	@PostMapping(value="/testAddFiche")
	public FichePresence addAllFP(@RequestBody FichePresence fp) {
		
		ficheR.save(fp);
		return fp;
	}
}
