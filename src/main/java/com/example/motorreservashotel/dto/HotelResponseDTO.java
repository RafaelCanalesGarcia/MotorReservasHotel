package com.example.motorreservashotel.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// LOMBOK
@AllArgsConstructor
@Getter
@Setter

public class HotelResponseDTO {

    @NotBlank
    private final String name;

    @NotBlank
    private final String address;

    @NotBlank
    private final String city;

    @NotBlank
    private final String country;

    @Min(1)
    @Max(5)
    private final Integer stars;



}
