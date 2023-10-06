package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Student;
import com.example.demo.models.Todo;
import com.example.demo.service.TodoServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Todo list 相關api")
@RestController
public class TodoController
{
	@Autowired
	TodoServiceImpl todoServiceImpl;

	@GetMapping(value = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "取得所有代辦事項列表", httpMethod = "GET")
	@ApiResponses({ @ApiResponse(code = 401, message = "沒有權限"), @ApiResponse(code = 404, message = "找不到路徑") })
	public ResponseEntity<String> test(@RequestParam("name") String name)
	{
		String result = "你的name is:" + name;
		String result1 = null;
		Optional.ofNullable(result).orElseThrow(() -> new RuntimeException("Data not found for name: " + name));
		return ResponseEntity.ok(result);
	}

	@GetMapping("/todos")
	public ResponseEntity<List<Student>> getAllTodos()
	{
		List<Student> todos = todoServiceImpl.getAllTodos();
		return ResponseEntity.ok(todos);
	}

	@GetMapping("/todos/{id}")
	public ResponseEntity<Student> getTodoById(@PathVariable int id)
	{
		Student todo = todoServiceImpl.getById(id);
		Optional.ofNullable(todo).orElseThrow(() -> new RuntimeException("Data not found for id:" + id));
		return ResponseEntity.ok(todo);
	}

	@PostMapping("/todos")
	public ResponseEntity<Student> createTodo(@RequestBody Todo todo)
	{
		Student createdTodo = todoServiceImpl.createTodo(todo);
		Optional.ofNullable(createdTodo).orElseThrow(() -> new RuntimeException("Data not created !"));
		return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
	}

	@PutMapping("/todos/{id}")
	public ResponseEntity<Student> updateTodo(@PathVariable int id, @RequestBody String name)
	{
		Student updatedTodo = todoServiceImpl.updateTodo(id, name);
		Optional.ofNullable(updatedTodo).orElseThrow(() -> new RuntimeException("Data not updated !"));
		return ResponseEntity.ok(updatedTodo);
	}

	@DeleteMapping("/todos/{id}")
	public ResponseEntity<Boolean> deleteTodo(@PathVariable int id)
	{
		// 實作根據ID刪除代辦事項的邏輯
		boolean deletedTodo = todoServiceImpl.deleteTodo(id);
		Optional.ofNullable(deletedTodo).orElseThrow(() -> new RuntimeException("Data not deleted !"));
		return ResponseEntity.ok(true);

	}

}
