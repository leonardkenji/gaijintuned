package com.kawashita.gaijintuned.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kawashita.gaijintuned.infrastructure.entity.Cars;

public interface CarsRepository extends JpaRepository <Cars, Long> {

}
