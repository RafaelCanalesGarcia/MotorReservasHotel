package com.example.motorreservashotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Entity

// LOMBOK
@Getter
@Setter

public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotBlank
    private String country;

    @Min(1)
    @Max(5)
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
