package com.kawashita.gaijintuned.controller;

import com.kawashita.gaijintuned.infrastructure.repository.ExperienceRepository;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kawashita.gaijintuned.infrastructure.entity.Experience;
import com.kawashita.gaijintuned.service.ExperienceService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/experiences")
@RequiredArgsConstructor
public class ExperienceController {

  private final ExperienceRepository experienceRepository;
  private final ExperienceService experienceService;

  //getAll working
  @GetMapping
  public ResponseEntity<List<Experience>> findAll(){
    return ResponseEntity.ok(experienceService.findAll());
  }

  //getOne
  @GetMapping("/{id}")
  public ResponseEntity<Experience> findById(@PathVariable Long id){
    return ResponseEntity.ok(experienceService.findById(id));
  }

  //save
  @Transactional
  @PostMapping
  public ResponseEntity<Experience> save(@RequestBody Experience experience){
    return ResponseEntity.ok(experienceService.save(experience));
  }

  //update
  @Transactional
  @PutMapping("/{id}")
  public ResponseEntity<Experience> update(@PathVariable Long id, @RequestBody Experience experience){
    return ResponseEntity.ok(experienceService.update(id, experience));
  }

  //delete
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Long id){
    experienceRepository.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
