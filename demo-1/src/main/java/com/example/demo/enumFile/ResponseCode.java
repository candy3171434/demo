package com.example.demo.enumFile;

import lombok.Getter;

@Getter
public enum ResponseCode
{
	SUCCESS(200, "Success"),

	INTERNAL_ERROR(1, "伺服器內部錯誤"),

	USER_INPUT_ERROR(2, "使用者輸入錯誤"),

	AUTHENTICATION_NEEDED(3, "Token過期或無效"),

	FORBIDDEN(4, "禁止存取"),

	TOO_FREQUENT_VISIT(5, "存取太頻繁，請休息一會兒");

	private final int code;

	private final String message;
	


	ResponseCode(int code, String message)
	{
		this.code = code;
		this.message = message;
	}

}
