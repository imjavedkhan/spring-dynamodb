package com.primus.springdynamodb.controller;

import com.primus.springdynamodb.entity.User;
import com.primus.springdynamodb.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/user")
     public User saveUser(@RequestBody User user){
         return userRepo.save(user);
     }

     @GetMapping("/user/{id}")
     public User getUser(@PathVariable("id") String userId){
        return userRepo.getUserById(userId);
     }

     @DeleteMapping("/user/{id}")
     public String deleteUser(@PathVariable("id") String userId){
         return userRepo.delete(userId);
     }

     @PutMapping("/user/{id}")
     public String updateUser(@PathVariable("id") String userId,@RequestBody User user){
        return userRepo.update(userId,user);
     }
}
