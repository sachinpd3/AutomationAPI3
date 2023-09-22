package EndPoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;


import Payload.PetPajo;

import io.restassured.response.Response;

public class PetEndPoints
{

	
	static ResourceBundle Geturl()
	{
		ResourceBundle route= ResourceBundle.getBundle("Route");
		return route;
	}
	
	
	 public static Response CreatePet(PetPajo load) 
		{
		 //Payload Payload = new Payload();
		 
		 String PostPet=Geturl().getString("PostPetUrl");
		 Response response=given()
		.contentType("application/json")
		.body(load)
		.log().all()
		.when()
		.post(PostPet);
		
		return response;
		
		}
	    
	    
	    public static Response GetPet(int id) 
		{
		 //Payload Payload = new Payload();
	    	String GetPet=Geturl().getString("GetPetUrl");
		 Response response=given()
		.header("Content-Type", "application/json")
		.pathParam("petId",id )
		.when()
		.get(GetPet);
		return response;
		
		}
	    
	    
	   public static Response UpdatePet(int id) 
		{
		 //Payload Payload = new Payload();
	    	String UpdatePet=Geturl().getString("PutPetUrl");
		 Response response=given()
				 .contentType("application/x-www-form-urlencoded")
	             .formParams("name", "rajjesss", "status","unavailable")
	             .pathParam("petId",id )
		.log().all()
		.when()
		.post(UpdatePet);
		
		return response;
		
		}
	    
	    
	  
	    public static Response DeltePet(int id) 
	   	{
	   	 //Payload Payload = new Payload();
	    	String DeletePet=Geturl().getString("DeletePetUrl");
	   	 Response response=given()
	   			.header("api_key","special-key")
	   	.header("Content-Type", "application/json")
	   	.pathParam("petId", id)
	   	.when()
	   	.delete(DeletePet);
	   	
	   	return response;
	   	
	   	} 
	
	
}
