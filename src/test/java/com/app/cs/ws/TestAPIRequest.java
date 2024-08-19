package com.app.cs.ws;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.app.cs.ws.controller.ComputeController;

@SpringBootTest
@AutoConfigureMockMvc
public class TestAPIRequest {

	@Autowired
	private MockMvc mockMvc;
	
	//Test to check if Request is returning "0.0" without array input
	@Test
	public void testAPIRequestCall() throws Exception {
		this.mockMvc.perform(get("/compute/")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().string(containsString("0.0")));
	}	
}
