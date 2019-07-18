package com.employee.management.SpringBootRest;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.employee.management.bean.EmployeeList;
import com.employee.management.controller.EmployeeController;



@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRestApplicationTests {
	
//	@LocalServerPort
//    int randomServerPort;
	@Autowired
	private EmployeeController emp;
	
	RestTemplate restTemplate;
	 
	String baseUrl = "http://localhost:" + 8080 + "/kshitij/";
	@Test
	public void testHealthCheckUp() throws URISyntaxException {
		
		restTemplate=new RestTemplate();
	  
	    URI uri = new URI(baseUrl);
	 
	   ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals("Application is working Successfully.",emp.healthCheck());
	}
	
	@Test
	public void testGetWebService() throws URISyntaxException
	{
		baseUrl=baseUrl +"employee/get";

	    URI uri = new URI(baseUrl);
	    restTemplate=new RestTemplate();
	   ResponseEntity<EmployeeList>  result = restTemplate.getForEntity(uri, EmployeeList.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(result.getBody(), emp.getEmployeeDetails());
	   
	}

}

