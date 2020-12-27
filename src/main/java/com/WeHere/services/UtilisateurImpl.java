package com.WeHere.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WeHere.repositories.UtilisateurRepo;

@Service
public class UtilisateurImpl {

	@Autowired
	private UtilisateurRepo userR;
	
	
	
}
