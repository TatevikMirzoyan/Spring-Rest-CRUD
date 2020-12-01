package com.bdg.crud_spring_rest.airport_management_system.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author Tatevik Mirzoyan
 * Created on 18-Sep-20
 */

@Data
@NoArgsConstructor
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    Company company;

    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime time_in;
    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime time_out;

    String city_from;
    String city_too;

    @ManyToMany
    @JoinTable(name = "trip_passengers",
            joinColumns = {@JoinColumn(name = "passengers_id")},
            inverseJoinColumns = {@JoinColumn(name = "trips_id")})
    Set<Passenger> passengers;

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", company=" + company +
                ", time_in=" + time_in +
                ", time_out=" + time_out +
                ", city_from='" + city_from + '\'' +
                ", city_too='" + city_too + '\'' +
                '}';
    }
}
