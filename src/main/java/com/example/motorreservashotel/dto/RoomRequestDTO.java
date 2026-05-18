package com.example.motorreservashotel.dto;

import com.example.motorreservashotel.entity.RoomState;
import com.example.motorreservashotel.entity.RoomType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// LOMBOK
@AllArgsConstructor
@Getter
@Setter
public class RoomRequestDTO {
    @NotNull
    private final Integer number;

    @NotNull
    private final Integer capacity;

    @NotNull
    private final RoomState state;

    @NotNull
    private final RoomType type;

    @NotNull
    private final Long hotelId;


}
