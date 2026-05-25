package com.kawashita.gaijintuned.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kawashita.gaijintuned.infrastructure.entity.Car;
import com.kawashita.gaijintuned.infrastructure.repository.CarRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class CarService {

  private final CarRepository carsRepository;

  //index
  public List<Car> findAll(){
    return carsRepository.findAll();
  }

  //show
  public Car findById(Long id){
    return carsRepository.findById(id)
    .orElseThrow(() -> new RuntimeException("Car not found"));
  }
  //create
  @Transactional
  public Car save(Car car){
    return carsRepository.save(car);
  }


  //edit
  @Transactional
  public Car update(Long id, Car car){
    Car existing = findById(id);
    existing.setCarName(car.getCarName());
    existing.setCarSpecs(car.getCarSpecs());
    return carsRepository.save(existing);
  }

  //delete
  @Transactional
  public void deleteById(Long id){
    carsRepository.deleteById(id);
  }
}
