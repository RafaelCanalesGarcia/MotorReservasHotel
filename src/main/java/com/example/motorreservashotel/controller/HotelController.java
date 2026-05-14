package com.example.motorreservashotel.controller;

import com.example.motorreservashotel.entity.Hotel;
import com.example.motorreservashotel.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/hotels")

@RestController

public class HotelController {
    private final HotelService hs;

    public HotelController(HotelService hs) {
        this.hs = hs;
    }

    @GetMapping
    public List<Hotel> getHotels(){
        return hs.getHotels();
    }

    @PostMapping
    public Hotel addHotel(@Valid @RequestBody Hotel hotel){
       return hs.addHotel(hotel);

    }
    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Long id){

        return hs.findHotelById(id);
    }
}
