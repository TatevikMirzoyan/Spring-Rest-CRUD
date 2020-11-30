package com.bdg.crud.repository;

import com.bdg.crud.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tatevik Mirzoyan
 * Created on 11-Nov-20
 */
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
}
