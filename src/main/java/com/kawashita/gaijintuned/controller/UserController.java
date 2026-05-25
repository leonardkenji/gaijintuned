package com.kawashita.gaijintuned.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kawashita.gaijintuned.infrastructure.entity.User;
import com.kawashita.gaijintuned.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  //index
  @GetMapping
  public ResponseEntity<List<User>> findAll(){
    return ResponseEntity.ok(userService.findAll());
  }

  //show
  @GetMapping("/{id}")
  public ResponseEntity<User> findById(@PathVariable Long id){
    return ResponseEntity.ok(userService.findById(id));
  }

  //create
  @PostMapping
  public ResponseEntity<User> save(@RequestBody User user){
    return ResponseEntity.ok(userService.save(user));
  }

  //update
  @PutMapping("/{id}")
  public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
    return ResponseEntity.ok(userService.update(id, user));
  }

  //delete
  @DeleteMapping("/{id}")
  public ResponseEntity<User> deleteById(@PathVariable Long id){
    userService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

}
