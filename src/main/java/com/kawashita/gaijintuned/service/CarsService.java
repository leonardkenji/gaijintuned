package com.kawashita.gaijintuned.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kawashita.gaijintuned.infrastructure.entity.Cars;
import com.kawashita.gaijintuned.infrastructure.repository.CarsRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class CarsService {

  private final CarsRepository carsRepository;

  //index
  public List<Cars> findAll(){
    return carsRepository.findAll();
  }

  //show
  public Cars findById(Long id){
    return carsRepository.findById(id)
    .orElseThrow(() -> new RuntimeException("Car not found"));
  }
  //create
  @Transactional
  public Cars save(Cars car){
    return carsRepository.save(car);
  }


  //edit
  @Transactional
  public Cars update(Long id, Cars car){
    Cars existing = findById(id);
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
