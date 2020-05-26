package com.employeeapi.testCases;

import org.testng.annotations.BeforeClass;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;

public class TC006_AuthenticationAPI extends TestBase{
	
	@BeforeClass
	void checkAuthenticationAPI(){
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		PreemptiveBasicAuthScheme preemp=new PreemptiveBasicAuthScheme();
		preemp.setUserName("ToolsQA");
		preemp.setPassword("TestPassword");
		
		RestAssured.authentication=preemp;
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET, "/");
		String res=response.getBody().asString();
		System.out.println(res);

	}
	
	

}
