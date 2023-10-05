package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Todo;

@Service
public class TodoServiceImpl implements TodoService
{

	@Override
	public Todo createTodo(Todo todo)
	{
		Todo data=new Todo(todo.getId(), todo.getName());
		return data;
	}

	@Override
	public Todo updateTodo(int id, String name)
	{
		return new Todo(id, name);
	}

	@Override
	public Todo getById(int id)
	{
		return new Todo(0, "testName");
	}

	@Override
	public List<Todo> getAllTodos()
	{
		List<Todo> lists=new ArrayList<Todo>();
		lists.add(new Todo(0, "testName0"));
		lists.add(new Todo(1, "testName1"));
		return lists;
	}

	@Override
	public boolean deleteTodo(int id)
	{
		// TODO Auto-generated method stub
		return true;
	}

}
