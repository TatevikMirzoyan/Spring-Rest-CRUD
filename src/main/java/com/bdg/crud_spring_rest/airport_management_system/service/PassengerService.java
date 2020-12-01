package com.bdg.crud_spring_rest.airport_management_system.service;

import com.bdg.crud_spring_rest.airport_management_system.model.Passenger;
import com.bdg.crud_spring_rest.airport_management_system.model.Trip;
import com.bdg.crud_spring_rest.airport_management_system.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Tatevik Mirzoyan
 * Created on 18-Nov-20
 */
@Service
public class PassengerService {
    @Autowired
    PassengerRepository passengerRepository;

    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("Hibernate_JPA");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Passenger getById(int id) {
        Optional<Passenger> passenger = passengerRepository.findById(id);
        return passenger.orElse(null);
    }

    public Set<Passenger> getAll() {
        Set<Passenger> passengers = new HashSet<>();
        Iterable<Passenger> iterable = passengerRepository.findAll();
        for (Passenger passenger : iterable) {
            passengers.add(passenger);
        }
        return passengers;
    }

    //TODO
    @SuppressWarnings("unchecked")
    public Set<Passenger> get(int page, int perPage, String sort) {
        String query = "SELECT p FROM Passenger p order by p." + sort;
        return (Set<Passenger>) entityManager
                .createQuery(query)
                .setFirstResult(((page - 1) * perPage))
                .setMaxResults(perPage)
                .getResultStream()
                .collect(Collectors.toSet());
    }

    public Passenger save(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger update(Passenger passenger) {
        Passenger updatedPassenger = getById(passenger.getId());
        updatedPassenger.setName(passenger.getName());
        updatedPassenger.setPhone(passenger.getPhone());
        updatedPassenger.setAddress(passenger.getAddress());
        passengerRepository.save(updatedPassenger);
        return updatedPassenger;
    }

    public void delete(int passengerId) {
        passengerRepository.deleteById(passengerId);
    }

    //TODO
    public List<Passenger> getPassengersOfTrip(int tripNumber) {
        return null;
    }

    public void registerTrip(Trip trip, Passenger passenger) {

    }

    public void cancelTrip(int passengerId, int tripNumber) {

    }
}
