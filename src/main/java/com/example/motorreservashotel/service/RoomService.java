package com.example.motorreservashotel.service;

import com.example.motorreservashotel.entity.Hotel;
import com.example.motorreservashotel.entity.Room;
import com.example.motorreservashotel.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository rr;

    public RoomService(RoomRepository rr) {
        this.rr = rr;
    }

    public List<Room> getFromHotelId(Long hotel_id){
        return rr.getByHotelId(hotel_id);
    }
}
