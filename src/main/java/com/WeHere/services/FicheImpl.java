package com.WeHere.services;

import java.sql.Time;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WeHere.beans.FichePresence;
import com.WeHere.repositories.FicheRepo;

@Service
public class FicheImpl {

	@Autowired
	private FicheRepo ficheR;
	
	
	public FichePresence addFiche(FichePresence fp) {
		// recup user connecté
		Date dateJour = new Date();
		System.out.println(dateJour);
		fp.setDateJourPresence(dateJour);
		return fp;		
	}
	
	
	
}
