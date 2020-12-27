package com.WeHere.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.WeHere.beans.Classe;
@Repository
public interface ClasseRepo extends CrudRepository<Classe, Integer> {


}
