package com.example.motorreservashotel.controller;

import com.example.motorreservashotel.entity.Hotel;
import com.example.motorreservashotel.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void addHotel(@RequestBody Hotel hotel){
        hs.addHotel(hotel);

    }
}
