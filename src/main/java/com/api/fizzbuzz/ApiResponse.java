package com.api.fizzbuzz;

import java.util.List;

import com.api.fizzbuzz.models.FizzBuzz;

/*
 * The ApiResponse is the container for the api's response message.
 * */
public class ApiResponse {
	
	private Integer status;
	private String message;
	private List<FizzBuzz> data;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<FizzBuzz> getData() {
		return data;
	}
	public void setData(List<FizzBuzz> data) {
		this.data = data;
	}
	
}
