package EndPoints;

import java.util.ResourceBundle;
import Payload.UserPajo;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class UserEndPoints
{

	static ResourceBundle Geturl()
	{
		ResourceBundle route= ResourceBundle.getBundle("Route");
		return route;
	}
	
	public static Response CreateUser(UserPajo Payload)
	{
		String PostUser=Geturl().getString("PostUserUrl");
		Response response=	given()
			.header("Content-Type","application/json")
		   .accept("application/json")
		.body(Payload)
		.log().all()
		.when()
		.post(PostUser);
	
return response;
			
	}
	
	public static Response GetUser(String username)
	{
		String GettUser=Geturl().getString("GetUserUrl");
		Response response=	given()
			.header("Content-Type","application/json")
		   .accept("application/json")
		   .pathParam("username", username)
		.log().all()
		.when()
		.get(GettUser);
	
return response;
			
	}
	
	public static Response UpdateUser(String username,UserPajo Payload)
	{
		String PostUser=Geturl().getString("PutUserUrl");
		Response response=	given()
			.header("Content-Type","application/json")
		   .accept("application/json")
		   .pathParam("username", username)
		.body(Payload)
		.log().all()
		.when()
		.put(PostUser);
		
	return response;
			
	}
	
	public static Response DeleteUser(String username)
	{
		String DeleteUser=Geturl().getString("DeleteUserUrl");
		Response response=	given()
			.header("Content-Type","application/json")
		   .accept("application/json")
		   .pathParam("username", username)
		.log().all()
		.when()
		.delete(DeleteUser);
		
return response;
			
	}
	
	
}
