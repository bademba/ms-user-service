package com.baproject.userservice.controller;

import com.baproject.userservice.entity.User;
import com.baproject.userservice.repository.UserRepository;
import com.baproject.userservice.response.ResponseHandler;
import com.baproject.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/v1/userservice")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
     UserRepository userRepository;

    UUID uuid = UUID.randomUUID();
    Date date = new Date();
    SimpleDateFormat DateFor = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    String timestamp = DateFor.format(date);

    @GetMapping("/users")
    public ResponseEntity<List<User>> users(){
        return new ResponseEntity(userService.users(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id){
         return new ResponseEntity(userService.get(id),HttpStatus.OK);
    }
    @PostMapping("/users/newUser")
    public ResponseEntity saveUser(@RequestBody User user){
         return ResponseHandler.generateResponse(uuid,"User created successfully",HttpStatus.CREATED,userService.saveUser(user),timestamp);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Integer id){
        try{
            User userEXist =userService.get(id);
            userService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(NoSuchElementException e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.delete(id);
    }
}
