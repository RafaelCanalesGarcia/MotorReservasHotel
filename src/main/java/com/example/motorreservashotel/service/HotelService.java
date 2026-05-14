package com.example.motorreservashotel.service;


import com.example.motorreservashotel.entity.Hotel;
import com.example.motorreservashotel.exception.HotelNotFoundException;
import com.example.motorreservashotel.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    private final HotelRepository hr;

    public HotelService(HotelRepository hr) {
        this.hr = hr;
    }


    public Hotel addHotel(Hotel hotel){
        return hr.save(hotel);
    }

    public List<Hotel> getHotels(){
        return hr.findAll();
    }

    public Hotel findHotelById(Long id){
        return hr.findById(id).orElseThrow(() -> new HotelNotFoundException("Hotel not found."));
    }


}
