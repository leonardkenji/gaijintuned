package com.kawashita.gaijintuned.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kawashita.gaijintuned.infrastructure.entity.Experience;
import com.kawashita.gaijintuned.infrastructure.repository.ExperienceRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExperienceService {

  private final ExperienceRepository experienceRepository;

  //index
  public List<Experience> findAll(){
    return experienceRepository.findAll();
  }

  //show
  public Experience findById(Long id){
    return experienceRepository.findById(id)
    .orElseThrow(()-> new RuntimeException("Experience not found"));
  }

  //create
  public Experience save(Experience experience){
    return experienceRepository.save(experience);
  }

  //update
public Experience update (Long id, Experience experience){
  Experience existingExperience = findById(id);
  existingExperience.setExperienceName(experience.getExperienceName());
  existingExperience.setExperienceDescription(experience.getExperienceDescription());

  return experienceRepository.save(existingExperience);
}

  //delete
  public void deleteById(Long id){
    experienceRepository.deleteById(id);
  }
}
