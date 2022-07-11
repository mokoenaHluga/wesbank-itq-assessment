package com.itq.assessment.contoller;

import com.itq.assessment.controller.PalindromeController;
import com.itq.assessment.service.PalindromeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(controllers = PalindromeController.class)
public class PalindromeControllerTest {
    @Autowired
    private MockMvc mockmvc;

    @MockBean
    private PalindromeService palindromeService;

    @Test
    void testGetAllUsers() throws Exception {
        String stringToCheck = "the last year until 2112 that can be written the same way backward or forward.";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/palindrome/{data}", stringToCheck)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockmvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

}
