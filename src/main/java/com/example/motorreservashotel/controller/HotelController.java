package com.example.motorreservashotel.controller;

import com.example.motorreservashotel.dto.HotelRequestDTO;
import com.example.motorreservashotel.dto.HotelResponseDTO;
import com.example.motorreservashotel.entity.Hotel;
import com.example.motorreservashotel.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/hotels")

@RestController

public class HotelController {
    private final HotelService hs;

    public HotelController(HotelService hs) {
        this.hs = hs;
    }

    private HotelResponseDTO toHotelResponse(Hotel hotel){
        return new HotelResponseDTO(
                hotel.getName(),
                hotel.getAddress(),
                hotel.getCity(),
                hotel.getCountry(),
                hotel.getStars());
    }
    private Hotel toHotelEntity(HotelRequestDTO request){
        return new Hotel(
                request.getName(),
                request.getCity(),
                request.getAddress(),
                request.getCountry(),
                request.getStars());
    }

    private void updateHotel (Hotel hotel, HotelRequestDTO request){
        hotel.setName(request.getName());
        hotel.setAddress(request.getAddress());
        hotel.setCity(request.getCity());
        hotel.setCountry(request.getCountry());
        hotel.setStars(request.getStars());
    }

    @GetMapping
    public List<HotelResponseDTO> getHotels(){
        List<Hotel> hotels = hs.getHotels();
        return hotels.stream().map(this::toHotelResponse).toList();
    }

    @PostMapping
    public HotelResponseDTO addHotel(@Valid @RequestBody HotelRequestDTO request){
       return toHotelResponse(hs.addHotel(toHotelEntity(request)));
    }
    @GetMapping("/{id}")
    public HotelResponseDTO getHotelById(@PathVariable Long id){

        Hotel hotel = hs.findHotelById(id);

        return toHotelResponse(hotel);
    }

    @GetMapping("/country/{country}")
    public List<HotelResponseDTO> getHotelsByCountry(@PathVariable String country){
        List<Hotel> hotels = hs.findHotelsByCountry(country);
        return hotels.stream().map(this::toHotelResponse).toList();
    }

    @GetMapping("/city/{city}")
    public List<HotelResponseDTO> getHotelsByCity(@PathVariable String city){
        List<Hotel> hotels = hs.findHotelsByCity(city);
        return hotels.stream().map(this::toHotelResponse).toList();
    }

    @GetMapping("/stars/{stars}")
    public List<HotelResponseDTO> getHotelsByStars(@PathVariable Integer stars){
        List<Hotel> hotels = hs.findHotelsByStars(stars);
        return hotels.stream().map(this::toHotelResponse).toList();
    }

    @PutMapping("/{id}")
    public HotelResponseDTO putHotel(@Valid @RequestBody HotelRequestDTO request, @PathVariable Long id){
        Hotel hotel = hs.findHotelById(id);
        updateHotel(hotel,request);
        Hotel updatedHotel = hs.addHotel(hotel);
        return toHotelResponse(updatedHotel);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Long id){
        hs.deleteHotel(id);
    }
}
