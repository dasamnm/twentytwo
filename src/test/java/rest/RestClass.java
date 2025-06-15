package rest;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestClass {

	@Test
	public void testMethod() throws IOException, JSONException {

		RestAssured.baseURI = "https://reqres.in/api/users";
		Employee emp = new Employee();
		emp.setAge(22);
		emp.setContactNumber("87678968");
		emp.setDesignation("Cleaner");
		emp.setEmailId("EMAIL@GMAIL.COM");
		emp.setFirstName("Sagar");
		emp.setLastName("Wierd");
		emp.setSalary(17987342.233);


	 ObjectMapper objectMapper = new ObjectMapper();
	 String jsonPayload = objectMapper.writeValueAsString(emp);
		
		Response response =RestAssured.given()
				.contentType("application/json")
				.header("x-api-key","reqres-free-v1")
				.body(jsonPayload)
		.when()
			.post()
		.then()
			.log().all()	
			.extract().response();

		String responseBody = response.body().asString();
		
		Employee employee =objectMapper.readValue(responseBody, Employee.class);
		
		System.out.println(employee.getFirstName());
	}
}