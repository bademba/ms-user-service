package com.baproject.userservice;

import com.baproject.userservice.entity.User;
import com.baproject.userservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserepositoryUnitTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void findAllUsers(){
        //When
        List<User> users =this.userRepository.findAll();
        //Then
        assertEquals(4,users.size());
    }

    @Test
    void findUserById(){
        //Given
        Optional<User> user =this.userRepository.findById(1);

        //Then
        assertTrue(user.isPresent());
    }

    @Test
    void createNewUser(){
        //Given
        User user =new User();
        user.setFirstName("FIRST_NAME");
        user.setMiddleName("MIDDLE_NAME");
        user.setLastName("LAST_NAME");
        user.setId(1);

        //When
        User persistedUser =this.userRepository.save(user);

        //Then
        assertNotNull(persistedUser);
        assertEquals(1,persistedUser.getId());
    }

    @Test
    void deleteUserById(){
        //Given
        this.userRepository.deleteById(2);
        Optional<User> user =this.userRepository.findById(2);

        //THen
        assertFalse(user.isPresent());
    }

//    @Test
//    void updateUser(){
//        //Given
//        User user =new User();
//        user.setId(1);
//        user.setFirstName("FIRST_NAME");
//        user.setMiddleName("MIDDLE_NAME");
//        user.setLastName("LAST_NAME");
//
//        //When
//        User updatedUSer =new User();
//
//        //THen
//        assertNotNull(updatedUSer);
//        assertEquals("FIRST_NAME",updatedUSer.getFirstName());
//        assertEquals("",updatedUSer.getMiddleName());
//        assertEquals("LAST_NAME",updatedUSer.getLastName());
//        assertEquals(1,updatedUSer.getId());
//
//    }
    //https://devwithus.com/spring-boot-rest-api-unit-testing/
}
