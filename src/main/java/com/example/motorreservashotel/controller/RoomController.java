package com.example.motorreservashotel.controller;

import com.example.motorreservashotel.dto.RoomRequestDTO;
import com.example.motorreservashotel.dto.RoomResponseDTO;
import com.example.motorreservashotel.entity.Room;
import com.example.motorreservashotel.service.HotelService;
import com.example.motorreservashotel.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/rooms")

@RestController

public class RoomController {
    private final RoomService rs;
    private final HotelService hs;

    private RoomResponseDTO toRoomResponse(Room room){
        return new RoomResponseDTO(
                room.getNumber(),
                room.getCapacity(),
                room.getState(),
                room.getType(),
                room.getHotel().getName()
        );
    }

    private Room toEntityRoom(RoomRequestDTO request){
        return new Room(request.getNumber(),
                request.getCapacity(),
                request.getState(),
                request.getType(),
                hs.findHotelById(request.getHotelId()));
    }

    private void updateRoom(RoomRequestDTO request ,Room room){
        room.setNumber(request.getNumber());
        room.setCapacity(request.getCapacity());
        room.setState(request.getState());
        room.setType(request.getType());
        room.setHotel(hs.findHotelById(request.getHotelId()));
    }

    public RoomController(RoomService rs, HotelService hs) {
        this.rs = rs;
        this.hs = hs;
    }

    @GetMapping("/hotel/{hotelId}")
    public List<RoomResponseDTO> findByHotelId(@PathVariable Long hotelId){
        return rs.findByHotelId(hotelId).stream().map(this::toRoomResponse).toList();
    }

    @GetMapping("/{id}")
    public RoomResponseDTO findRoomById(@PathVariable Long id){
        return toRoomResponse(rs.findRoomById(id));
    }

    @PostMapping
    public RoomResponseDTO addRoom(@Valid @RequestBody RoomRequestDTO request){
        return toRoomResponse(rs.addRoom(toEntityRoom(request)));
    }

    @PutMapping("/{id}")
    public RoomResponseDTO updateRoom(@Valid @RequestBody RoomRequestDTO request, @PathVariable Long id){
        Room room = rs.findRoomById(id);
        updateRoom(request, room);
        Room roomUpdated = rs.addRoom(room);
        return toRoomResponse(roomUpdated);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id){
        rs.deleteRoomById(id);
    }
}
