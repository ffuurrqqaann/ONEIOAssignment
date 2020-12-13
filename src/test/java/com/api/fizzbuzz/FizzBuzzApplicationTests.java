package com.api.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.fizzbuzz.models.FizzBuzz;
import com.api.fizzbuzz.services.FizzBuzzService;
import com.api.fizzbuzz.services.FizzBuzzServiceImpl;

@SpringBootTest(classes = {FizzBuzzService.class, FizzBuzzServiceImpl.class})
@RunWith(SpringRunner.class)
class FizzBuzzApplicationTests {

	@Autowired
	FizzBuzzService fizzbuzzService;
	
	@TestConfiguration
	static class MoviesServiceImplTestContextConfiguration {

		@Bean
		public FizzBuzzService moviesService() {
			return new FizzBuzzServiceImpl();
		}
		
	}

	@Test
	void WhenNumber100isGiven_ThenTheListSizeReturnShouldBe100() {
		
		int number = 100;
		int divisible1 = 3;
		int divisible2 = 5;
		
		ApiResponse response = fizzbuzzService.getFizzBuzzResponse(number, divisible1, divisible2);
		
		assertThat(response.getData().size() == 100);
	}
	
	@Test
	void WhenNumber100IsGiven_AndDivisiblesAre3And5_ThenListContainingFizzBuzzIsCalculated() {
		
		int number = 100;
		int divisible1 = 3;
		int divisible2 = 5;
		
		ApiResponse response = fizzbuzzService.getFizzBuzzResponse(number, divisible1, divisible2);
		
		Predicate<FizzBuzz> byFizz = fizzbuzz -> fizzbuzz.getStringResponse().equalsIgnoreCase("Fizz");
		Predicate<FizzBuzz> byBuzz = fizzbuzz -> fizzbuzz.getStringResponse().equalsIgnoreCase("Buzz");
		Predicate<FizzBuzz> byFizzBuzz = fizzbuzz -> fizzbuzz.getStringResponse().equalsIgnoreCase("FizzBuzz");
		
		List<FizzBuzz> listContainingFizz = response.getData().stream().filter(byFizz).collect(Collectors.toList());
		List<FizzBuzz> listContainingBuzz = response.getData().stream().filter(byBuzz).collect(Collectors.toList());
		List<FizzBuzz> listContainingFizzBuzz = response.getData().stream().filter(byFizzBuzz).collect(Collectors.toList());
		
		assertThat(listContainingFizz.size() == 27);
		assertThat(listContainingBuzz.size() == 14);
		assertThat(listContainingFizzBuzz.size() == 6);				
	}
	
	@Test
	void WhenNumberIsLessThanOrEqualToZero_ThenTheReturnedListIsEmpty() {
		
		int number = 0;
		int divisible1 = 3;
		int divisible2 = 5;
		
		ApiResponse response = fizzbuzzService.getFizzBuzzResponse(number, divisible1, divisible2);
		
		assertThat(response.getData().size() == 0);
		assertThat(response.getStatus() == 400);
		assertThat(response.getMessage().equals("Invalid Number, It should be greater than or equal to 1"));
	}
	
	@Test
	void WhenDivisible1IsLessThanOrEqualToZero_ThenTheReturnedListIsEmpty() {
		
		int number = 100;
		int divisible1 = -3;
		int divisible2 = 5;
		
		ApiResponse response = fizzbuzzService.getFizzBuzzResponse(number, divisible1, divisible2);
		
		assertThat(response.getData().size() == 0);
		assertThat(response.getStatus() == 400);
		assertThat(response.getMessage().equals("Invalid divisible1, It should be greater than or equal to 1"));
	}
	
	@Test
	void WhenDivisible2IsLessThanOrEqualToZero_ThenTheReturnedListIsEmpty() {
		
		int number = 100;
		int divisible1 = 3;
		int divisible2 = -5;
		
		ApiResponse response = fizzbuzzService.getFizzBuzzResponse(number, divisible1, divisible2);
		
		assertThat(response.getData().size() == 0);
		assertThat(response.getStatus() == 400);
		assertThat(response.getMessage().equals("Invalid divisible2, It should be greater than or equal to 1"));
	}

}