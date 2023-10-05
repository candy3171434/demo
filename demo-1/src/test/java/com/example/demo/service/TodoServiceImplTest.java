package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Todo;

@SpringBootTest
class TodoServiceImplTest
{
	@Autowired
	private TodoService todoService;
	
	@Test
//	@Disabled
	public void createTodoTest()
	{
		Todo data=todoService.createTodo(new Todo(1, "jack"));
		assertEquals(1, data);
		assertEquals("jack", data.getName());
	}
	
	@Test
	public void getByIdTest()
	{
		Todo data=todoService.getById(1);
		assertNotNull(data);
		assertEquals(0, data.getId());
	}
	
//	@Transactional
	@Test
	public void deleteTodoTest() {
		assertTrue(todoService.deleteTodo(0));
	}

}
