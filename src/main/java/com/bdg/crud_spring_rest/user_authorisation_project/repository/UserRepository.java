package com.bdg.crud_spring_rest.user_authorisation_project.repository;

import com.bdg.crud_spring_rest.user_authorisation_project.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tatevik Mirzoyan
 * Created on 11-Nov-20
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
