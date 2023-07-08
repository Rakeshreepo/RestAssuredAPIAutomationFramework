package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserendPoints {
	
	public static Response createUser(User payloads) {
		
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payloads)
		
		.when()
			.post(Rotues.userPost_url);
		
		return response;
	}
	
	public static Response getUser(String username) {
		
		Response response = given()
			.pathParam("username", username)
		
		.when()
			.get(Rotues.userGet_url);
		
		return response;
	}
	
	public static Response updateUser(String username, User payloads) {
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.body(payloads)
			
			.when()
				.put(Rotues.userUpdate_url);
			
			return response;
		}
	
	public static Response DeleteUser(String username) {
		
		Response response = given()
					.pathParam("username", username)
			.when()
				.delete(Rotues.userDelete_url);
			
			return response;
		}
	
	

}
