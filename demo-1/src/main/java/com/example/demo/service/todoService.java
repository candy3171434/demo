package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Todo;

public interface todoService
{
	public Todo createTodo(Todo todo);

	public Todo updateTodo(int id, String name);

	public Todo getById(int id);

	public List<Todo> getAllTodos();

	public boolean deleteTodo(int id);
	
}
