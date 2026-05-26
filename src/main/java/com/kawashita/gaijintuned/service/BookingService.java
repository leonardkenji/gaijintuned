package com.kawashita.gaijintuned.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kawashita.gaijintuned.infrastructure.entity.Booking;
import com.kawashita.gaijintuned.infrastructure.repository.BookingRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookingService {

  private final BookingRepository bookingRepository;

  //index
  public List<Booking> findAll(Long userId){
    return bookingRepository.findAll();
  }

  //show
  public Booking findById(Long userId, Long id) {
    return bookingRepository.findById(id)
    .orElseThrow(()-> new RuntimeException("Booking not found"));
  }

  //create
  @Transactional
  public Booking save(Booking booking){
    return bookingRepository.save(booking);
  }
  //edit
  @Transactional
  public Booking update(Long userId, Long id, Booking booking){
    Booking existingBooking = findById(userId, id);
    existingBooking.setCar(booking.getCar());
    existingBooking.setUser(booking.getUser());

    return bookingRepository.save(existingBooking);
  }

  //delete
  @Transactional
  public void deleteById(Long id){
    bookingRepository.deleteById(id);
  }

}
