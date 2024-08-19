package com.app.cs.ws.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.cs.ws.model.Data;
import com.app.cs.ws.service.ComputeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping(value = "/compute")
public class ComputeController {
	
	@Autowired
	private ComputeService computeService;
	
	@GetMapping
	// An array will be passed as parameter
	public double computeSquareRootOfSumOfSquaresOfThreeHighestNumbers(Integer[] data) {
		if(data == null) return 0.0;
		Integer[] numbersArray = data;		
		return computeService.getSquareRootOfSumOfSquaresOfThreeHighestNumbers(numbersArray);
	}
	
	@PostMapping
	// Object Data will be passed as parameter
	public String computeSquareRootOfSumOfSquaresOfThreeHighestNumbers(@RequestBody Data data) {

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode outputJSON = mapper.createObjectNode();
		
		if(data.getData() == null) return "0.0";

		Integer[] numbers = data.getData();

		double outputJsonDouble = computeService.getSquareRootOfSumOfSquaresOfThreeHighestNumbers(numbers);
		outputJSON.put("output", outputJsonDouble);
		
		var outputJsonString = outputJSON.toString();
        return outputJsonString;
	}
	
	//@PostMapping
	// Object Data will be passed as parameter
	public String computeSquareRootOfSumOfSquaresOfThreeHighestNumbers(@RequestBody JSONObject data) {
		var outputJsonString = data.toString();
		return outputJsonString;
	}
}
