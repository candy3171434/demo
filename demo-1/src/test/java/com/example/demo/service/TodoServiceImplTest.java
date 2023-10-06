package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Student;
import com.example.demo.models.Todo;

@SpringBootTest
class TodoServiceImplTest
{
	@Autowired
	private TodoService todoService;
	
	@Test
	public void getByIdTest()
	{
		Student data=todoService.getById(1);
		assertNotNull(data);
		assertEquals(0, data.getStudentId());
	}
	
//	@Transactional
	@Test
	public void deleteTodoTest() {
		assertTrue(todoService.deleteTodo(0));
	}

}
