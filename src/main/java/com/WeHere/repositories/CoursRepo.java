package com.WeHere.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.WeHere.beans.Cours;

@Repository
public interface CoursRepo extends CrudRepository<Cours, Integer>{

}
