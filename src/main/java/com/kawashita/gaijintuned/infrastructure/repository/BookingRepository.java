package com.kawashita.gaijintuned.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kawashita.gaijintuned.infrastructure.entity.Booking;

public interface BookingRepository extends JpaRepository <Booking, Long>{

}
