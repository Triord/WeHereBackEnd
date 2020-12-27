package com.WeHere.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.WeHere.beans.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Integer> {

}
