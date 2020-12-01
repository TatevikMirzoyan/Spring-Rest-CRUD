package com.bdg.crud_spring_rest.airport_management_system.service;

import com.bdg.crud_spring_rest.airport_management_system.model.Trip;
import com.bdg.crud_spring_rest.airport_management_system.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;

/**
 * @author Tatevik Mirzoyan
 * Created on 18-Nov-20
 */
@Service
public class TripService {

    @Autowired
    TripRepository tripRepository;

    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("Hibernate_JPA");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Trip getById(int id) {
        Optional<Trip> trip = tripRepository.findById(id);
        return trip.orElse(null);
    }

    public Set<Trip> getAll() {
        Set<Trip> trips = new HashSet<>();
        Iterable<Trip> iterable = tripRepository.findAll();
        for (Trip trip : iterable) {
            trips.add(trip);
        }
        return trips;
    }

    @SuppressWarnings("unchecked")
    public Set<Trip> get(int page, int perPage, String sort) {
        Set<Trip> trips = new LinkedHashSet<>();
        String query = "SELECT t FROM Trip t order by t." + sort;
        try {
            List<Trip> list = (List<Trip>) entityManager
                    .createQuery(query)
                    .setMaxResults(perPage)
                    .setFirstResult(((page - 1) * perPage))
                    .getResultList();
            trips.addAll(list);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        entityManager.close();
        return trips;
    }

    public Trip save(Trip trip) {
        return tripRepository.save(trip);
    }

    public Trip update(Trip trip) {
        Trip updatedTrip = getById(trip.getId());
        updatedTrip.setCompany(trip.getCompany());
        updatedTrip.setCity_from(trip.getCity_from());
        updatedTrip.setCity_too(trip.getCity_too());
        updatedTrip.setTime_out(trip.getTime_out());
        updatedTrip.setTime_in(trip.getTime_in());
        tripRepository.save(updatedTrip);
        return updatedTrip;
    }

    public void delete(int tripId) {
        tripRepository.deleteById(tripId);
    }

    @SuppressWarnings("unchecked")
    public List<Trip> getTripsFrom(String city) {
        Query query = entityManager.createQuery("SELECT t FROM Trip t WHERE t.city_from = ?1");
        List<Trip> list = (List<Trip>) query
                .setParameter(1, city)
                .getResultList();
        entityManager.close();
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<Trip> getTripsTo(String city) {
        Query query = entityManager.createQuery("SELECT t FROM Trip t WHERE t.city_too = ?1");
        List<Trip> list = (List<Trip>) query
                .setParameter(1, city)
                .getResultList();
        entityManager.close();
        return list;
    }
}
