package com.itq.assessment.contoller;

import com.itq.assessment.controller.UserController;
import com.itq.assessment.dto.UserDto;
import com.itq.assessment.service.UserService;
import com.itq.assessment.test.data.JsonObjectConverter;
import com.itq.assessment.test.data.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @MockBean
    private UserService userService;

    @Test
    void testGetAllUsers() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/user/all")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockmvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    void testGetUserById() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/user/find/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockmvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    void testUpdateUser() throws Exception {
        UserDto user = TestData.getUser("Thabo", "Tough Guy", "jih.ji@yahoo.com", "0112839872", 1L);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/user/update")
                .content(JsonObjectConverter.getJsonFromObject(user))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockmvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    void testAddUser() throws Exception {
        UserDto user = TestData.getUser("Thabo", "Tough Guy", "jih.ji@yahoo.com", "0112839872", 1L);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/user/add")
                .content(JsonObjectConverter.getJsonFromObject(user))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockmvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    void testDeleteUser() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/user/delete/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockmvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

}
