package com.kawashita.gaijintuned.controller;
import java.util.List;
import com.kawashita.gaijintuned.infrastructure.entity.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kawashita.gaijintuned.service.BookingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users/{userId}/bookings")
@RequiredArgsConstructor
public class BookingController {

  private final BookingService bookingService;

  //index show all users bookings
  @GetMapping
  public ResponseEntity<List<Booking>> findAll(@PathVariable Long userId){
    return ResponseEntity.ok(bookingService.findAll(userId));
  }

  //show show one booking details
  @GetMapping("/{id}")
  public ResponseEntity<Booking> findById(@PathVariable Long userId, @PathVariable Long id){
    return ResponseEntity.ok(bookingService.findById(userId, id));
  }

  //save a booking information
  @PostMapping
  public ResponseEntity<Booking> save(@RequestBody Booking booking){
    return ResponseEntity.ok(bookingService.save(booking));
  }

  //update a booking information - no needed actually

  //delete a booking - user can not actually delete de booking
}
