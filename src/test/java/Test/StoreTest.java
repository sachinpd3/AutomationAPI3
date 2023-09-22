package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import EndPoints.StoreEndPoints;
import EndPoints.UserEndPoints;
import Payload.StorePajo;
import Payload.UserPajo;
import io.restassured.response.Response;

public class StoreTest 
{

	Faker faker;
	StorePajo payload;
	int orderid;
	
	
	@BeforeClass
	public void data()
	{
		faker = new Faker();
		payload = new StorePajo();
		
		payload.setId(faker.number().numberBetween(1, 10));
		payload.setPetId(faker.number().randomDigitNotZero());
		payload.setQuantity(faker.number().numberBetween(1, 5));
		payload.setShipDate("2023-09-13T07:37:53.302Z");
		payload.setStatus("placed");
		
		orderid=payload.getId();
		
			
	}
	
	@Test(priority=1)
	public void crateorder()
	{
		
		Response response=	StoreEndPoints.CreateStore(payload);
		Assert.assertEquals(response.statusCode(), 200,"Status Code not matching");
		Assert.assertEquals(response.header("Content-Type"),"application/json","header not matching");
		
		
	}
	

	@Test(priority=2)
	public void getorder()
	{
		
		Response response=	StoreEndPoints.GetStore(orderid);
		Assert.assertEquals(response.statusCode(), 200,"Status Code not matching");
		Assert.assertEquals(response.header("Content-Type"),"application/json","header not matching");
		
		
	}
	
	

	@Test(priority=3)
	public void deleteorder()
	{
		
		Response response=	StoreEndPoints.DeleteStore(orderid);
		Assert.assertEquals(response.statusCode(), 200,"Status Code not matching");
		Assert.assertEquals(response.header("Content-Type"),"application/json","header not matching");
		
		
	}
	
}
