package com.app.cs.ws;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.cs.ws.controller.ComputeController;
import com.app.cs.ws.model.Data;

@SpringBootTest
public class TestRestController {
	
	//Set any list to compute.
	private static Integer[] numbers = {5,4,6,1};
	
	@Autowired
	private ComputeController computeController;

	@Test
	void testContextLoads() {
		assertThat(computeController).isNotNull();
	}
	
	//Test the logic of compute method
	@Test
	void testComputeMethodOnController() {
		Data data = new Data();
		data.setData(numbers);
		
		//A simple test if compute method is returning <> "0.0" when Array is passed.
		String outputStr = computeController.computeSquareRootOfSumOfSquaresOfThreeHighestNumbers(data);
		assertThat(outputStr).isNotEqualTo("0.0");
		
		//Print the output
		System.out.println(outputStr);
	}
}
