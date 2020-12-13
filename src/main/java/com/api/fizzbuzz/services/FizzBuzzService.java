package com.api.fizzbuzz.services;

import com.api.fizzbuzz.ApiResponse;

public interface FizzBuzzService {
	public ApiResponse getFizzBuzzResponse(int number, int divisible1, int divisible2);
}
