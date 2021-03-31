package com.WeHere.repositories;

import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.WeHere.beans.FichePresence;

@Repository
public interface FicheRepo extends CrudRepository<FichePresence, Integer>{

	@Query(value="select* from fichePresence fp join classe c on c.idClasse = fp.idClasse join cours crs on crs.idCours = fp.idCours where fp.heureCours = :heureCours and c.annee = :annee and c.nomSection = :nomSection and crs.nomCours = :nomCours and fp.dateJourPresence = :dateJourPresence", nativeQuery = true)
	Set <FichePresence> findallFicheByParams(String heureCours, int annee, String nomSection, String nomCours, String dateJourPresence);
	
	@Query(value="select* from fichePresence fp join classe c on c.idClasse = fp.idClasse join cours crs on crs.idCours = fp.idCours where fp.heureCours = :heureCours and c.annee = :annee and c.nomSection = :nomSection and crs.nomCours = :nomCours", nativeQuery = true)
	Set <FichePresence> findallFicheForVerif(String heureCours, int annee, String nomSection, String nomCours);
}
