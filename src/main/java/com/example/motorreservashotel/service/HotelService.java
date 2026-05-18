package com.example.motorreservashotel.service;


import com.example.motorreservashotel.entity.Hotel;
import com.example.motorreservashotel.exception.HotelNotFoundException;
import com.example.motorreservashotel.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Hotel> findHotelsByCountry(String country){
        return hr.findByCountryIgnoreCase(country);
    }

    public List<Hotel> findHotelsByCity(String city){
        return hr.findByCityIgnoreCase(city);
    }

    public List<Hotel> findHotelsByStars(Integer stars){
        return hr.findByStars(stars);
    }

    public void deleteHotel(Long id){
        Hotel hotel = findHotelById(id);
        hr.delete(hotel);
    }

}
