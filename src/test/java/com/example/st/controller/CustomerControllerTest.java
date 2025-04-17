package com.example.st.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.lang.System.Logger;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class CustomerControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
	void test() throws Exception {
        String userJson = """
                {
                    "custId": "customer01",
                    "password": "secret123",
                    "rgno": "9876543210"
                }
            """;

        MvcResult result = mockMvc.perform(post("/v1/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
        		.andExpect(status().isOk())
        		.andExpect(jsonPath("$.custId").value("customer01"))
        		.andExpect(jsonPath("$.password").value("secret123"))
        		.andExpect(jsonPath("$.rgno").value("9876543210"))
        		.andReturn();
        log.debug(result.getResponse().getContentAsString());
        
	}
}
