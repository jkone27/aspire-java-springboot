package com.example.aspirejava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) 
@ActiveProfiles(value = "test")
class DemoApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void contextLoads() {
	}

	@Test
	void testGet(){

		ResponseEntity<String> response = 
			restTemplate
			.getForEntity(
				"http://localhost:" + port + "/hello/JOHN", 
				String.class);
		
		Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

		Assertions.assertTrue(response.getBody().equals("hello: JOHN"));
	}

}
