package com.kawashita.gaijintuned.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kawashita.gaijintuned.infrastructure.entity.Car;

public interface CarRepository extends JpaRepository <Car, Long> {

}
