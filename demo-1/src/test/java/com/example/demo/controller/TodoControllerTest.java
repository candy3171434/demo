package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testEndpoint() throws Exception {
        String name = "John"; // 提供测试参数

        mockMvc.perform(MockMvcRequestBuilders.get("/api")
                .param("name", name) // 提供参数
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        		.andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("你的name is:" + name));
    }
    
    @Test
    public void testgetAllTodos()throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/todos"))
    			.andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    @Disabled
    public void testgetTodoById() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/todos/1"))
    	.andDo(print())
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(jsonPath("$.id", equalTo(1)));
    }
}
