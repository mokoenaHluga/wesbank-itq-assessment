package com.itq.assessment.contoller;

import com.itq.assessment.controller.ArrayIndexController;
import com.itq.assessment.service.ArrayIndexService;
import com.itq.assessment.test.data.JsonObjectConverter;
import com.itq.assessment.test.data.TestData;
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

@WebMvcTest(controllers = ArrayIndexController.class)
public class ArrayIndexControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @MockBean
    ArrayIndexService arrayIndexService;

    @Test
    void testGetAllUsers() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/array")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonObjectConverter.getJsonFromObject(TestData.getSumRequest(9, new int[]{2, 7, 11, 15})));

        MvcResult result = mockmvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

}
