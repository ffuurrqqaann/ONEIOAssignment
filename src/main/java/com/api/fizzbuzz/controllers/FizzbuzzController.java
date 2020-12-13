package com.api.fizzbuzz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.fizzbuzz.ApiResponse;
import com.api.fizzbuzz.services.FizzBuzzService;

@RestController
@RequestMapping("/api")
public class FizzbuzzController {
	
	@Autowired
	FizzBuzzService fizzbuzzService;
	
	@GetMapping(path="/fizzbuzz/{number}/{d1}/{d2}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ApiResponse getFizzBuzzResponse(@PathVariable(value="number") int number, @PathVariable(value="d1") int d1, @PathVariable(value="d2") int d2) {
		return fizzbuzzService.getFizzBuzzResponse(number, d1, d2);	
	}
	
}