package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserendPoints;
import api.payloads.User;
import api.utilities.DataProvider;
import io.restassured.response.Response;

public class UserDataExcel {
	
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProvider.class)
	public void testPostUser(String userID, String userName, String fname, String lname, String userEmail, String pwd, String ph) {
		
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(userEmail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response = UserendPoints.createUser(userPayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProvider.class)
	public void testDeleteUserByName(String userName) {
		
		Response response= UserendPoints.DeleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
