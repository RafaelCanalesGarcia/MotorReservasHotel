package com.example.motorreservashotel.repository;

import com.example.motorreservashotel.entity.Hotel;
import com.example.motorreservashotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {

    List<Room> getByHotelId(Long hotel_id);

    Long hotel_(Hotel hotel);
}
