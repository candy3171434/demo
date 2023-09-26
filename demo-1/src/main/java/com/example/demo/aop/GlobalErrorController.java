package com.example.demo.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.enumFile.ResponseCode;
import com.example.demo.result.BaseResult;

@ControllerAdvice
public class GlobalErrorController
{
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public ResponseEntity<BaseResult> handleException(RuntimeException e)
	{
		BaseResult result = new BaseResult(ResponseCode.INTERNAL_ERROR);
		result.setData(e.getMessage());
		System.out.println("錯誤訊息在這:"+e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
	}
}
