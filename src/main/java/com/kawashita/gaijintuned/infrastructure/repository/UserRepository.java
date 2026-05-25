package com.kawashita.gaijintuned.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kawashita.gaijintuned.infrastructure.entity.User;

public interface UserRepository extends JpaRepository <User, Long> {

}
