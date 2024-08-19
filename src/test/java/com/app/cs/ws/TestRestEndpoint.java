package com.app.cs.ws;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.event.EventListener;


// Class to test the REST template through HTTP call
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestRestEndpoint {

	@LocalServerPort
	private int port;
	
	@EventListener
	void onWebInit(WebServerInitializedEvent event) {
		port = event.getWebServer().getPort();
	}
	
	@Autowired
	private TestRestTemplate restApiTemplate;
	
	@Test
	public void testWebEndPointCall() {
		assertThat(this.restApiTemplate.getForObject("http://localhost:"+port+"/compute", 
				String.class)).contains("0.0");
	}	
}
