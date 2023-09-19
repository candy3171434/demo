package com.example.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.enumFile.ResponseCode;
import com.example.demo.result.BaseResult;
import com.google.gson.Gson;

@ControllerAdvice
public class GlobalErrorController
{

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public ResponseEntity<BaseResult> handleException(RuntimeException e)
	{
		BaseResult result = new BaseResult(ResponseCode.INTERNAL_ERROR);
		System.out.println("ddddd" + result);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
	}
}
