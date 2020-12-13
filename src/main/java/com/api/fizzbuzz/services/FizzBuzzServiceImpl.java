package com.api.fizzbuzz.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.fizzbuzz.ApiResponse;
import com.api.fizzbuzz.models.FizzBuzz;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

	@Override
	public ApiResponse getFizzBuzzResponse(int number, int divisible1, int divisible2) {

		List<FizzBuzz> fizzbuzzList = new ArrayList<>();
		ApiResponse response = new ApiResponse();

		// Return empty list for a number which is less than or equal to zero.
		if(number<=0) {
			response.setData(fizzbuzzList);
			response.setMessage("Invalid Number, It should be greater than or equal to 1");
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			
			return response;
		} else if (divisible1<=0) {
			response.setData(fizzbuzzList);
			response.setMessage("Invalid divisible1, It should be greater than or equal to 1");
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			
			return response;
		} else if (divisible2<=0) {
			response.setData(fizzbuzzList);
			response.setMessage("Invalid divisible2, It should be greater than or equal to 1");
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			
			return response;
		}

		IntStream.rangeClosed(1, number).forEach(i -> {
			String strResponse = i % divisible1 == 0 ? (i % divisible2 == 0 ? "FizzBuzz" : "Fizz") : (i % divisible2 == 0 ? "Buzz" : Integer.toString(i));

			FizzBuzz fzbz = new FizzBuzz();
			fzbz.setNumber(i);
			fzbz.setStringResponse(strResponse);

			fizzbuzzList.add(fzbz);
		});
		
		response.setData(fizzbuzzList);
		response.setMessage("Success");
		response.setStatus(HttpStatus.OK.value());
		
		return response;
	}
}