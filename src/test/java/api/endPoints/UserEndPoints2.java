package api.endPoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payLoads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public  class UserEndPoints2 {
	
	public static ResourceBundle getUrl(){
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}

	public static Response createUser(User userPayLoad) {
		
		String post_user = getUrl().getString("post_user");

		Response response = given()

				.contentType(ContentType.JSON).accept(ContentType.JSON).body(userPayLoad).when()
				.post(post_user);

		return response;
	}

	public  static Response getUser(String userName) {
		
		String get_user = getUrl().getString("get_user");

		Response response = given()

				.accept(ContentType.JSON).pathParam("userName", userName).when()
				.get(get_user);

		return response;
	}

	public static  Response updateUser(User userPayLoad, String userName) {
		
		String update_user = getUrl().getString("update_user");
		
		
		Response response = given()

					.contentType(ContentType.JSON).accept(ContentType.JSON).body(userPayLoad)
					.pathParam("userName", userName)
				.when()
					.put(update_user);

		return response;

	}

	public static Response  deleteUser(String userName) {
		
		String delete_user = getUrl().getString("delete_user");
		
		 Response response = given()

			.accept(ContentType.JSON)
			.pathParam("userName", userName)
		.when()
			.get(delete_user);
		 
		 return response;

	}

}
