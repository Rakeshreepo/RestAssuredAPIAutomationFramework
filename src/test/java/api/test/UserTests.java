package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserendPoints;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userPayloads;
	
	@BeforeClass
	public void setUpData() {
		
		faker = new Faker();
		userPayloads = new User();
		
		userPayloads.setId(faker.idNumber().hashCode());
		userPayloads.setUsername(faker.name().username());
		userPayloads.setFirstName(faker.name().firstName());
		userPayloads.setLastName(faker.name().lastName());
		userPayloads.setEmail(faker.internet().emailAddress());
		userPayloads.setPassword(faker.internet().password(5,10));
		userPayloads.setPhone(faker.phoneNumber().cellPhone());
	}
	
	@Test(priority = 1)
	public void testPostUser() {
		
		Response response = UserendPoints.createUser(userPayloads);
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2)
	public void testGetUserByName() {
		
		Response response = UserendPoints.getUser(this.userPayloads.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("2 done");
	}
	
	@Test(priority = 3)
	public void testUpdateUserByName() {
		
		userPayloads.setEmail(faker.internet().emailAddress());
		
		Response response = UserendPoints.updateUser(this.userPayloads.getUsername(),userPayloads);	
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Response responseAfterUpdationUser = UserendPoints.getUser(this.userPayloads.getUsername());
		response.then().log().body();
		Assert.assertEquals(responseAfterUpdationUser.getStatusCode(), 200);
	}
	@Test(priority = 4)
	public void testDeleteUserByName() {
		
		Response response = UserendPoints.DeleteUser(this.userPayloads.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
