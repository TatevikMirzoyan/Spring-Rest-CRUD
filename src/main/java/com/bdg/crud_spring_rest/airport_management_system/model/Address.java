package com.bdg.crud_spring_rest.airport_management_system.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Tatevik Mirzoyan
 * Created on 18-Sep-20
 */
@Data
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String country;
    String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
