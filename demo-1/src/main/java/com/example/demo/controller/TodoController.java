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
	public ResponseEntity<List<Todo>> getAllTodos()
	{
		List<Todo> todos = todoServiceImpl.getAllTodos();
		return ResponseEntity.ok(todos);
	}

	@GetMapping("/todos/{id}")
	public ResponseEntity<Todo> getTodoById(@PathVariable int id)
	{
		Todo todo = todoServiceImpl.getById(id);
		if (todo != null)
		{
			return ResponseEntity.ok(todo);
		} else
		{
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/todos")
	public ResponseEntity<Todo> createTodo(@RequestBody Todo todo)
	{
		Todo createdTodo = todoServiceImpl.createTodo(todo);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
	}

	@PutMapping("/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable int id, @RequestBody String name)
	{
		Todo updatedTodo = todoServiceImpl.updateTodo(id, name);
		if (updatedTodo != null)
		{
			return ResponseEntity.ok(updatedTodo);
		} else
		{
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable int id)
	{
		// 實作根據ID刪除代辦事項的邏輯
		boolean deleted = todoServiceImpl.deleteTodo(id);
		if (deleted)
		{
			return ResponseEntity.noContent().build();
		} else
		{
			return ResponseEntity.notFound().build();
		}
	}

}
