package com.app.cs.ws.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ComputeService {	
	
	//ExcelDocument workbook = new ExcelDocument(2);
	
	// Get the 3 highest numbers from an array 
	private static List<Integer> getThreeHighestNumbers(Integer[] numbers) {
		int limit = 3;
		List<Integer> numberslist = Arrays.asList(numbers);
		return numberslist
				.parallelStream()		
				.sorted(Comparator.reverseOrder())
				.limit(limit)
				.collect(Collectors.toList());
	}
	
	//Get the square of 3 highest numbers from an array
	private static List<Integer> getSquareOfHighestNumbers(List<Integer> numbers) {
		return numbers.parallelStream()
		.map(num -> num*num)
		.toList();
	}
	
	//Get the sum of square of 3 highest numbers from an array
	private static int getSumOfSquareOfHighestNumbers(List<Integer> numbers) {
			return numbers.parallelStream()
			.reduce(0, Integer::sum);
		}
	
	//Get the square root of sum of square of 3 highest numbers from an array
	public double getSquareRootOfSumOfSquaresOfThreeHighestNumbers(Integer[] numbers) {
		
		List<Integer> highestNumbersList = getThreeHighestNumbers(numbers);		
		List<Integer> squareOfNumbersList = getSquareOfHighestNumbers(highestNumbersList);		
		Integer sumOfsquareOfNumbersInt = getSumOfSquareOfHighestNumbers(squareOfNumbersList);

		return Math.sqrt(sumOfsquareOfNumbersInt);
	}
}
