package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Student;
import com.example.demo.models.Todo;

@Service
public interface TodoService
{
	public Student createTodo(Todo todo);

	public Student updateTodo(int id, String name);

	public Student getById(int id);

	public List<Student> getAllTodos();

	public boolean deleteTodo(int id);

}
