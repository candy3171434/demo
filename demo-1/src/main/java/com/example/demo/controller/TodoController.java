package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.enumFile.ResponseCode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Todo list 相關api")
@RestController
public class TodoController
{

	// ,produces = {"text/plain;charset=UTF-8"}
	// 无法将@ExceptionHandler返回的数据转换@RequestMapping.produces所要求的格式。
	@GetMapping(value = "/api")
	@ApiOperation(value = "取得所有代辦事項列表", httpMethod = "GET")
	@ApiResponses({ @ApiResponse(code = 401, message = "沒有權限"), @ApiResponse(code = 404, message = "找不到路徑") })
	public ResponseEntity<String> test(@RequestParam("name") String name)
	{
		String res = "你的name is:" + name;
		return ResponseEntity.ok(res);
	}
	
}
