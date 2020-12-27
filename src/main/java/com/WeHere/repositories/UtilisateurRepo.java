package com.WeHere.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.WeHere.beans.Utilisateur;


@Repository
public interface UtilisateurRepo extends CrudRepository<Utilisateur, Integer>{

	@Query(value="select* from utilisateur",nativeQuery=true)
	Set <Utilisateur> findAllByOrder();
	
	@Query(value="select* from utilisateur u join classe c on u.idClasse = c.idClasse where c.annee = :annee and c.nomSection = :nomSection", nativeQuery = true)
	Set <Utilisateur> findallUserByClasse(int annee, String nomSection);
}
