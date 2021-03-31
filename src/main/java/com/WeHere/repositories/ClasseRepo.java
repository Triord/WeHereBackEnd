package com.WeHere.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.WeHere.beans.Classe;
@Repository
public interface ClasseRepo extends CrudRepository<Classe, Integer> {

	@Query(value="select* from classe where annee = :annee and nomSection = :nomSection", nativeQuery = true)
	Classe findClasseByYearsAndName(int annee, String nomSection);
	
}
