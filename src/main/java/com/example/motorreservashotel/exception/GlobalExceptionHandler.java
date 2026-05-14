package com.example.motorreservashotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleHotelNotFound(HotelNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", ex.getMessage()));
    }
}
