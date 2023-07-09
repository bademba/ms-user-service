package com.baproject.userservice;

import com.baproject.userservice.entity.User;
import com.baproject.userservice.repository.UserRepository;
import com.baproject.userservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceUnitTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void findAllUsers_should_return_list(){
        User user=this.buildTestingUser();
        
        //when
        when(userRepository.findAll()).thenReturn(List.of(user));
        List<User> users =this.userService.users();
        
        //then
        assertEquals(1,users.size());
        verify(this.userRepository).findAll();
    }

    private User buildTestingUser() {
        User user=new User();
        user.setId(1);
        user.setFirstName("FIRST_NAME");
        user.setMiddleName("MIDDLE_NAME");
        user.setLastName("LAST_NAME");
        return  user;
    }

}
