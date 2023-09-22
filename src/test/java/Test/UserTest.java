package Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import EndPoints.UserEndPoints;
import Payload.UserPajo;
import io.restassured.response.Response;

public class UserTest 
{

	Faker faker;
	UserPajo payload;
	String username;
	public static Logger logger;
	
	@BeforeClass
	public void data()
	{
		faker = new Faker();
		payload = new UserPajo();
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().emailAddress());
		payload.setId(faker.internet().hashCode());
		payload.setPassword(faker.internet().password());
		payload.setPhone(faker.phoneNumber().cellPhone());
		payload.setUsername(faker.name().username());
		
		
		username=payload.getUsername();
		
		
		logger=LogManager.getLogger("APIAutomation3");
		
			
	}
	
	@Test(priority=1)
	public void crateuser()
	{
		logger.info("---Start Create User--");
		Response response=	UserEndPoints.CreateUser(payload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200,"Status Code not matching");
		Assert.assertEquals(response.header("Content-Type"),"application/json","header not matching");
	}
	
	
	@Test(priority=2)
	public void getuser()
	{
		logger.info("---Start get User--");
		Response response=	UserEndPoints.GetUser(username);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200,"Status Code not matching");
		Assert.assertEquals(response.header("Content-Type"),"application/json","header not matching");
		
	}
	

	@Test(priority=3)
	public void updateuser()
	{
		logger.info("---Start Update User--");
		faker = new Faker();
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		Response response=	UserEndPoints.UpdateUser(username,payload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 201,"Status Code not matching");
		Assert.assertEquals(response.header("Content-Type"),"application/json","header not matching");
		Assert.assertEquals(response.jsonPath().get("type"), "unknown");
		
	}
	
	

	@Test(priority=4)
	public void deleteuser()
	{
		logger.info("---Start delete User--");
		Response response=	UserEndPoints.DeleteUser(username);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200,"Status Code not matching");
		Assert.assertEquals(response.header("Content-Type"),"application/json","header not matching");
		Assert.assertEquals(response.jsonPath().get("type"), "unknown");
		
	}
	
}
