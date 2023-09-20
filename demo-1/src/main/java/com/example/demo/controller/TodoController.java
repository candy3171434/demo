package com.example.demo.controller;

import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Todo list 相關api")
@RestController
public class TodoController
{
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

}
