package com.example.motorreservashotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity

// LOMBOK
@Getter
@Setter

public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String city;
    private String country;
    private Integer stars;

    public Hotel(String name, String city, String address, String country, Integer stars) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.country = country;
        this.stars = stars;
    }

    public Hotel() {
    }

}
