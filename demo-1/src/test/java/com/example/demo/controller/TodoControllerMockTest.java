package com.example.demo.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension; // 引入 MockitoExtension
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.domain.Student;
import com.example.demo.service.TodoServiceImpl;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class) // 使用 MockitoExtension
class TodoControllerMockTest
{
	@Mock
	private TodoServiceImpl todoService;
	@InjectMocks
	private TodoController todoController;

	@Test
	public void testGetAllTodos()
	{
		List<Student> mockTodos = new ArrayList<>();
		mockTodos.add(new Student(1, "JACK"));
		mockTodos.add(new Student(2, "MOLE"));

		when(todoService.getAllTodos()).thenReturn(mockTodos);

		// 调用controller的getAllTodos()方法
		ResponseEntity<List<Student>> responseEntity = todoController.getAllTodos();

		// 验证是否正确调用了todoService的getAllTodos()方法一次
		verify(todoService, times(1)).getAllTodos();

		assert (responseEntity.getStatusCode() == HttpStatus.OK);

		List<Student> returnedStudents = responseEntity.getBody();
		assert (returnedStudents != null);
		assert (returnedStudents.size() == 2);
		assert (returnedStudents.get(0).getStudentId() == 1);
		assert (returnedStudents.get(0).getName().equals("JACK"));
		assert (returnedStudents.get(1).getStudentId() == 2);
		assert (returnedStudents.get(1).getName().equals("MOLE"));
	}
}
