package com.example.demo.result;

import com.example.demo.enumFile.ResponseCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResult
{
	private int code;
	private String message;
	private Object data;

	public BaseResult(ResponseCode responseCode)
	{
		this.code = responseCode.getCode();
		this.message = responseCode.getMessage();
	}

}
