package com.bdg.crud_spring_rest.airport_management_system.repository;

import com.bdg.crud_spring_rest.airport_management_system.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tatevik Mirzoyan
 * Created on 17-Sep-20
 */
@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {

}
