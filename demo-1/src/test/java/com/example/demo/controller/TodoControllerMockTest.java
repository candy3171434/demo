package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.models.Todo;
import com.example.demo.service.TodoServiceImpl;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class TodoControllerMockTest
{
	@MockBean
	private TodoServiceImpl todoService;
	@InjectMocks
	private TodoController todoController;
	@BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

	@Test
	public void testGetAllTodos()
	{

		List<Todo> mockTodos = new ArrayList<>();
		mockTodos.add(new Todo(1, "JACK"));
		mockTodos.add(new Todo(2, "MOLE"));

		when(todoService.getAllTodos()).thenReturn(mockTodos);

		// 调用controller的getAllTodos()方法
		ResponseEntity<List<Todo>> responseEntity = todoController.getAllTodos();

		// 验证是否正确调用了todoService的getAllTodos()方法一次
		verify(todoService, times(1)).getAllTodos();

		assert (responseEntity.getStatusCode() == HttpStatus.OK);

		List<Todo> returnedTodos = responseEntity.getBody();
		assert (returnedTodos != null);
		assert (returnedTodos.size() == 2);
		assert (returnedTodos.get(0).getId() == 1);
		assert (returnedTodos.get(0).getName().equals("JACK"));
		assert (returnedTodos.get(1).getId() == 2);
		assert (returnedTodos.get(1).getName().equals("MOLE"));
	}

}
