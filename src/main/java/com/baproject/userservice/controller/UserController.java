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
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/v1/userservice")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
     UserRepository userRepository;

    Date date = new Date();
    SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String timestamp = DateFor.format(date);

    @GetMapping("/users")
    public ResponseEntity<Object> users(){
        return ResponseHandler.generateResponse(UUID.randomUUID(),"Users successfully retrieved",HttpStatus.OK,userService.users(),timestamp);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id){
        return ResponseHandler.generateResponse(UUID.randomUUID(),"User details retrieved successfully",HttpStatus.OK,userService.get(id),timestamp);
    }
    @PostMapping("/users/newUser")
    public ResponseEntity saveUser(@RequestBody User user){
         return ResponseHandler.generateResponse(UUID.randomUUID(),"User created successfully",HttpStatus.CREATED,userService.saveUser(user),timestamp);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Integer id){
        User currentUser=userService.get(id);
        if(currentUser ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentUser.setFirstName(user.getFirstName());
        currentUser.setMiddleName(user.getMiddleName());
        currentUser.setLastName(user.getLastName());

        User updatedUser =userService.saveUser(currentUser);
        return ResponseHandler.generateResponse(UUID.randomUUID(),"User details updated successfully",HttpStatus.OK,updatedUser,timestamp);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id){

        userService.delete(id);
    }
}
