package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endPoints.UserEndPoints;
import api.payLoads.User;
import api.utilities.DataProviderMethods;
import io.restassured.response.Response;

public class DataDrivenUserApiTesting {
	User userpayloads;
	
	@Test(priority = 1 , dataProvider = "UserApiData", dataProviderClass =DataProviderMethods.class)
	public void testPostUser(String userId, String userName, String FirstName, String LastName, String Email, String Password, String Phone) {
		
		userpayloads = new User();
		
		userpayloads.setId(Integer.parseInt(userId));
		userpayloads.setUsername(userName);
		userpayloads.setFirstName(FirstName);
		userpayloads.setLastName(LastName);
		userpayloads.setEmail(Email);
		userpayloads.setPassword(Password);
		userpayloads.setPhone(Phone);
		
		
		Response response = UserEndPoints.createUser(userpayloads);
		
		response.then().log().all();

		Assert.assertEquals(response.statusCode(), 200);

	}
	@Test(priority = 1 , dataProvider = "userName", dataProviderClass =DataProviderMethods.class)

	public void testGetUser(String userName) {
		
		Response response = UserEndPoints.getUser(userName);
		response.then().log().all();

		Assert.assertEquals(response.statusCode(), 200);
		
	}
	
	 
	
	
	
	
	
	
	@Test(priority = 1 , dataProvider = "userName", dataProviderClass =DataProviderMethods.class)

	public void testdeleteUser(String userName) {
		
		Response response = UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.statusCode(), 200);
		
	}

}
