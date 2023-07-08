package api.endpoints;



/*CreateUser --> https://petstore.swagger.io/v2/user
GetUser --> https://petstore.swagger.io/v2/user/{username}
UpdateUser --> https://petstore.swagger.io/v2/user/{username}
DeleteUser --> https://petstore.swagger.io/v2/user/{username} */

public class Rotues {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	public static String userPost_url = base_url+"/user";
	public static String userGet_url = base_url+"/user/{username}";
	public static String userUpdate_url = base_url+"/user/{username}";
	public static String userDelete_url = base_url+"/user/{username}";

}
