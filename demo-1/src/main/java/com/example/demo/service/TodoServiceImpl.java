package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentRepository;
import com.example.demo.domain.Student;
import com.example.demo.models.Todo;

@Service
public class TodoServiceImpl implements TodoService
{
	//(required = false) => WTF
	@Autowired(required = false) 
	private StudentRepository studentRepository;

	@Override
	public Student createTodo(Todo todo)
	{
		Student data = new Student(todo.getId(), todo.getName());
		return studentRepository.save(data);
	}

	@Override
	public Student updateTodo(int id, String name)
	{
		Student data = new Student(id, name);
		return studentRepository.save(data);
	}

	@Override
	public Student getById(int id)
	{
		return studentRepository.findById(id).get();
	}

	@Override
	public List<Student> getAllTodos()
	{
		return studentRepository.findAll();
	}

	@Override
	public boolean deleteTodo(int id)
	{
		if (studentRepository.findById(id).isPresent())
		{
			studentRepository.deleteById(id); // 正確的刪除方法
			return true;
		}
		return false;
	}

}
