package api.endPoints;

public class Routes {
	
	//Base url for whole Project
	public static String base_url = "https://petstore.swagger.io/v2"
			+ "";
	
	
	//user Module
	
	public static String post_create_user = base_url+"/user";
	public static String get_user = base_url+"/user/{userName}";
	public static String update_user = base_url+"/user/{userName}";
	public static String delete_user = base_url+"/user/{userName}";

}
