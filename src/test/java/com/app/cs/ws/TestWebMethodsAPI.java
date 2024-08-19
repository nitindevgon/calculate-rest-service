package com.app.cs.ws;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.json.simple.JSONArray;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.app.cs.ws.service.*;
import com.app.cs.ws.controller.ComputeController;
import com.app.cs.ws.model.Data;

//Mock test for controller with operations.
@WebMvcTest(ComputeController.class)
public class TestWebMethodsAPI {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ComputeService restService;
	
	@Test
	public void testPostComputeMethod() throws Exception {
		Double suqareRoot = 0.0;
		String numbersJson = "{\"data\":[5,4,6,1]}";
		
		when(restService.getSquareRootOfSumOfSquaresOfThreeHighestNumbers(Mockito.any(Integer[].class)))
		.thenReturn(suqareRoot);
		
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/compute")
                .accept(MediaType.APPLICATION_JSON)
                .content(numbersJson)
                .contentType(MediaType.APPLICATION_JSON);;
        
        MvcResult result = this.mockMvc.perform(requestBuilder)
        		.andExpect(status().isOk())        		
        		.andReturn();
		
        MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	@Test
	public void testGetComputeMethod() throws Exception {
		Double suqareRoot = 0.0;
		String numbersJson = "{\"data\":[5,4,6,1]}";

		when(restService.getSquareRootOfSumOfSquaresOfThreeHighestNumbers(Mockito.any(Integer[].class)))
		.thenReturn(suqareRoot);
        
		RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/compute")
                .accept(MediaType.APPLICATION_JSON)
                .content(numbersJson)
                .contentType(MediaType.APPLICATION_JSON);;
        
        MvcResult result = this.mockMvc.perform(requestBuilder)
        		.andExpect(status().isOk())        		
        		.andReturn();
		
        MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
}
