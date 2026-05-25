package com.kawashita.gaijintuned.service;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.kawashita.gaijintuned.infrastructure.entity.User;
import com.kawashita.gaijintuned.infrastructure.repository.UserRepository;

import jakarta.transaction.Transactional;

@RequiredArgsConstructor
@Service

public class UserService {

  private final UserRepository userRepository;

  //index
  public List<User> findAll(){
    return userRepository.findAll();
  }

  //show
  public User findById(Long id){
    return userRepository.findById(id)
    .orElseThrow(()->new RuntimeException("User no found"));
  }

  //create
  @Transactional
  public User save(User user){
    return userRepository.save(user);
  }

  //edit
  @Transactional
  public User update(Long id, User user){
    User existing = findById(id);
    existing.setFirstName(user.getFirstName());
    existing.setLastName(user.getLastName());
    existing.setEmail(user.getEmail());
    existing.setPhoneNumber(user.getPhoneNumber());
    return userRepository.save(existing);
  }

  //delete
  @Transactional
  public void deleteById(Long id){
    userRepository.deleteById(id);
  }
}
