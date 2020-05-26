package com.employeeapi.testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC007_Get_Weather extends TestBase{
	
	
	@BeforeClass
	void getWeatherDetails() throws InterruptedException{
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET, "/chennai");
		
		Thread.sleep(5000);
		
		
	}
	
	@Test
	void get(){
		String res=response.getBody().asString();
		System.out.println(res);
		JsonPath json=response.jsonPath();
	
		
		System.out.println(json.get("City"));
	}

}
