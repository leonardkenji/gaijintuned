package com.kawashita.gaijintuned.controller;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.kawashita.gaijintuned.infrastructure.entity.Cars;
import com.kawashita.gaijintuned.service.CarsService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarsController {
  private final CarsService carsService;

  //index - Get the cars from DB
  @GetMapping
  public ResponseEntity<List<Cars>> findAll(){
    return ResponseEntity.ok(carsService.findAll());
  }

  //show - Get one car from DB
  @GetMapping("/{id}")
  public ResponseEntity<Cars> findById(@PathVariable Long id){
    return ResponseEntity.ok(carsService.findById(id));
  }

  //Save information in the DB
  @PostMapping
  public ResponseEntity<Cars> save(@RequestBody Cars car){
    return ResponseEntity.ok(carsService.save(car));
  }

  //Edit information in the DB
  @PutMapping("/{id}")
  public ResponseEntity<Cars> update(@PathVariable Long id, @RequestBody Cars car){
    return ResponseEntity.ok(carsService.update(id, car));
  }

  //Delete information in the DB
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Long id){
    carsService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
