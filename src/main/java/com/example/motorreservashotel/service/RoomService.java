package com.example.motorreservashotel.service;

import com.example.motorreservashotel.entity.Room;
import com.example.motorreservashotel.exception.RoomNotFoundException;
import com.example.motorreservashotel.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository rr;

    public RoomService(RoomRepository rr) {
        this.rr = rr;
    }

    public List<Room> findByHotelId(Long hotel_id){
        return rr.findByHotelId(hotel_id);
    }

    public Room addRoom(Room room){
        return rr.save(room);
    }

    public Room findRoomById(Long id){
        return rr.findById(id).orElseThrow(() -> new RoomNotFoundException("Room not found."));
    }

    public void deleteRoomById(Long id){
        Room room = findRoomById(id);
        rr.delete(room);
    }
}
