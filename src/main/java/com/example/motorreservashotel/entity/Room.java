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

    public Room(Integer number,Integer capacity,RoomState state, RoomType type,Hotel hotel) {
        this.hotel = hotel;
        this.type = type;
        this.state = state;
        this.capacity = capacity;
        this.number = number;
    }

    public Room() {
    }
}
/*
Host    ep-cool-cherry-al0gnobm.c-3.eu-central-1.aws.neon.tech
Database    neondb
Role    neondb_owner
Password    ************
Pooler host ep-cool-cherry-al0gnobm-pooler.c-3.eu-central-1.aws.neon.tech

postgresql://neondb_owner:npg_TzhE07SRslZG@ep-cool-cherry-al0gnobm.c-3.eu-central-1.aws.neon.tech/neondb?sslmode=require

 */