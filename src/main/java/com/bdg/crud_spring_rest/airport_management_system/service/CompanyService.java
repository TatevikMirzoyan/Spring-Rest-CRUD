package com.bdg.crud_spring_rest.airport_management_system.service;

import com.bdg.crud_spring_rest.airport_management_system.model.Company;
import com.bdg.crud_spring_rest.airport_management_system.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

/**
 * @author Tatevik Mirzoyan
 * Created on 18-Nov-20
 */
@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;


    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("Hibernate_JPA");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Company getById(int id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.orElse(null);
    }

    public Set<Company> getAll() {
        Set<Company> companies = new HashSet<>();
        Iterable<Company> iterable = companyRepository.findAll();
        for (Company company : iterable) {
            companies.add(company);
        }
        return companies;
    }

    @SuppressWarnings("unchecked")
    public Set<Company> get(int page, int perPage, String sort) {
        Set<Company> companies = new LinkedHashSet<>();
        String query = "SELECT c FROM Company c order by c." + sort;
        try {
            List<Company> list = (List<Company>) entityManager
                    .createQuery(query)
                    .setMaxResults(perPage)
                    .setFirstResult(((page - 1) * perPage))
                    .getResultList();
            companies.addAll(list);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        entityManager.close();
        return companies;
    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Transactional
    public Company update(Company company) {
        Company updatedCompany = getById(company.getId());
        updatedCompany.setName(company.getName());
        updatedCompany.setFound_date(company.getFound_date());
        save(updatedCompany);
        return company;
    }

    public void delete(int companyId) {
        companyRepository.deleteById(companyId);
    }

}
