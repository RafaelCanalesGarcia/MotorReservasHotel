package com.example.motorreservashotel.controller;

import com.example.motorreservashotel.dto.RoomResponseDTO;
import com.example.motorreservashotel.entity.Hotel;
import com.example.motorreservashotel.entity.Room;
import com.example.motorreservashotel.service.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/rooms")

@RestController

public class RoomController {
    private final RoomService rs;

    private RoomResponseDTO toRoomResponse(Room room){
        return new RoomResponseDTO(
                room.getNumber(),
                room.getCapacity(),
                room.getState(),
                room.getType(),
                room.getHotel().getName()
        );
    }
    public RoomController(RoomService rs) {
        this.rs = rs;
    }

    @GetMapping("hotel/{hotel_id}")
    public List<RoomResponseDTO> getFromHotelId(@PathVariable Long hotel_id){
        return rs.getFromHotelId(hotel_id).stream().map(this::toRoomResponse).toList();
    }
}
