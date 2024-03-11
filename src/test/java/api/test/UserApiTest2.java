package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import api.endPoints.UserEndPoints2;
import api.payLoads.User;

import io.restassured.response.Response;

public class UserApiTest2 {

	User userpayloads;
	Faker faker;
	
	public Logger logger;

	@BeforeClass
	public void setUpData() {

		faker = new Faker();
		userpayloads = new User();
		userpayloads.setId(faker.idNumber().hashCode());
		userpayloads.setUsername(faker.name().username());
		userpayloads.setFirstName(faker.name().firstName());
		userpayloads.setLastName(faker.name().lastName());
		userpayloads.setEmail(faker.internet().emailAddress());
		userpayloads.setPassword(faker.internet().password(5, 10));
		userpayloads.setPhone(faker.phoneNumber().cellPhone());
		
		
		// logs
		logger= LogManager.getLogger(this.getClass());
		logger.debug("debugging.......");
		
		
	}

	@Test(priority = 1)
	public void testPostUser() {

		logger.info("=======>Creating user<=======");
		Response response = UserEndPoints2.createUser(userpayloads);
		response.then().log().all();

		Assert.assertEquals(response.statusCode(), 200);
		logger.info("=======> User Created<=======");
	}

	@Test(priority = 2)
	public void testGetUser() {

		logger.info("=======>reading user info<=======");
		Response response = UserEndPoints2.getUser(this.userpayloads.getUsername());
		response.then().log().all();

		Assert.assertEquals(response.statusCode(), 200);

		logger.info("=======>User info displayed <=======");
	}
	
	@Test(priority = 3)
	public void testUpdateUser() {

		logger.info("=======>Update user<=======");
		
		userpayloads.setLastName(faker.name().lastName());
		userpayloads.setPhone(faker.phoneNumber().cellPhone());
		userpayloads.setFirstName(faker.name().firstName());
		
		Response response = UserEndPoints2.updateUser(userpayloads, this.userpayloads.getUsername());
		response.then().log().all();

		Assert.assertEquals(response.statusCode(), 200);

		logger.info("=======> user Updated<=======");
	}
	
	@Test(priority = 4)
	public void testDeleteUser() {
		
		logger.info("=======> Delete user<=======");
		
		Response response = UserEndPoints2.deleteUser(this.userpayloads.getUsername());
		
		Assert.assertEquals(response.statusCode(), 200);
		
		logger.info("=======> user Deleted<=======");
	}

}
