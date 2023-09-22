package EndPoints;

import java.util.ResourceBundle;

import Payload.StorePajo;
import Payload.UserPajo;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class StoreEndPoints
{

	static ResourceBundle Geturl()
	{
		ResourceBundle route= ResourceBundle.getBundle("Route");
		return route;
	}
	
	public static Response CreateStore(StorePajo Payload)
	{
		String PostUser=Geturl().getString("PostStorerUrl");
		Response response=	given()
			.header("Content-Type","application/json")
		   .accept("application/json")
		.body(Payload)
		.log().all()
		.when()
		.post(PostUser);
	
return response;
			
	}
	
	public static Response GetStore(int orderid)
	{
		String GettUser=Geturl().getString("GetStoreUrl");
		Response response=	given()
			.header("Content-Type","application/json")
		   .accept("application/json")
		   .pathParam("orderId", orderid)
		.log().all()
		.when()
		.get(GettUser);
	
return response;
			
	}
	
	
	
	public static Response DeleteStore(int orderid)
	{
		String DeleteUser=Geturl().getString("DeleteStoreUrl");
		Response response=	given()
			.header("Content-Type","application/json")
		   .accept("application/json")
		   .pathParam("orderId", orderid)
		.log().all()
		.when()
		.delete(DeleteUser);
		
return response;
			
	}
	
	
}
