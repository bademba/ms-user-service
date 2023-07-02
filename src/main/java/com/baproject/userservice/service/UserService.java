package com.baproject.userservice.service;

import com.baproject.userservice.entity.User;
import com.baproject.userservice.exception.ResourceNotFoundException;
import com.baproject.userservice.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> users(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User getUser(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new ResourceNotFoundException(String.format("User with ID %s not found", id));
        }
        //return userOptional.get();
        return userRepository.findById(id).get();

    }

    public void delete(Integer id) {
//        if(userRepository.existsById(id)){
//            userRepository.deleteById(id);
//        }
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new ResourceNotFoundException(String.format("User with ID %s not found", id));
        }
        userRepository.deleteById(id);
    }
}
