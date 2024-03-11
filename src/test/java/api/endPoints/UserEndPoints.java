package api.endPoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payLoads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public  class UserEndPoints {

	public static Response createUser(User userPayLoad) {

		Response response = given()

				.contentType(ContentType.JSON).accept(ContentType.JSON).body(userPayLoad).when()
				.post(Routes.post_create_user);

		return response;
	}

	public  static Response getUser(String userName) {

		Response response = given()

				.accept(ContentType.JSON).pathParam("userName", userName).when()
				.get(Routes.get_user);

		return response;
	}

	public static  Response updateUser(User userPayLoad, String userName) {
		Response response = given()

					.contentType(ContentType.JSON).accept(ContentType.JSON).body(userPayLoad)
					.pathParam("userName", userName)
				.when()
					.put(Routes.update_user);

		return response;

	}

	public static Response  deleteUser(String userName) {
		
		 Response response = given()

			.accept(ContentType.JSON)
			.pathParam("userName", userName)
		.when()
			.get(Routes.get_user);
		 
		 return response;

	}

}
