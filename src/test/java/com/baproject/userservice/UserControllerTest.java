package com.baproject.userservice;

import com.baproject.userservice.controller.UserController;
import com.baproject.userservice.entity.User;
import com.baproject.userservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Base64;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
class UserControllerTest {
    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin", password = "password")

    void list_all_users() throws Exception{
        User user=this.buildTestingUser();
        when(userService.users()).thenReturn(List.of(user));

        mockMvc.perform(get("/v1/userservice/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
//                .andExpect(content().contentTypeCompatibleWith("application/json"))

//                .andExpect(jsonPath("$.data",hasSize(2)))
//                .andExpect(jsonPath("$.data.[0].id",is(1)))
//                .andExpect(jsonPath("$.data.[0].firstName",is("FIRST_NAME")))
//                .andExpect(jsonPath("$.data.[0].middleName",is("MIDDLE_NAME")))
//                .andExpect(jsonPath("$.data.[0].lastName",is("LAST_NAME")))
//                .andExpect(jsonPath("$.message",is("message")))
//                .andExpect(jsonPath("$.responseId",is("responseId")))
//                .andExpect(jsonPath("$.status",is(200)))
//                .andExpect(jsonPath("$.timestamp",is("timestamp")));
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
