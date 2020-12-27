package com.WeHere.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.WeHere.beans.FichePresence;

@Repository
public interface FicheRepo extends CrudRepository<FichePresence, Integer>{

}
