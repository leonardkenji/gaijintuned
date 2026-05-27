package com.kawashita.gaijintuned.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kawashita.gaijintuned.infrastructure.entity.Experience;

public interface ExperienceRepository extends JpaRepository <Experience,Long> {

}
