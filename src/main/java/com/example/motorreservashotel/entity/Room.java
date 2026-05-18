package com.example.motorreservashotel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer number;

    @NotNull
    private Integer capacity;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RoomState state;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RoomType type;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;


}
