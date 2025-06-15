package rest;

import org.json.JSONException;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class demo {

	@Test
	public void testM() throws JSONException, JsonProcessingException {

		RestAssured.baseURI = "https://postman-echo.com/basic-auth";
		
		
		Response response = RestAssured.given()
			.auth().oauth(null, null, null, null)
				.header("Authorization","Bearer "+"Access Token")
		.when()
			.get()
		.then()
			.log().all()
			.extract().response()
		;
		
		boolean auth = response.jsonPath().getBoolean("authenticated");
		System.out.println(auth);
		System.out.println(response.getStatusCode());
		
	}
}