package Test;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import EndPoints.PetEndPoints;
import EndPoints.StoreEndPoints;
import EndPoints.UserEndPoints;
import Payload.PetPajo;
import Payload.StorePajo;
import Payload.UserPajo;
import Payload.CategoryPojo;
import Payload.TagsPojo;
import io.restassured.response.Response;

public class PetTest 
{

	Faker faker;
	PetPajo payload;
	int orderid;
	
	PetPajo loadn;
	CategoryPojo objCate;
	List<TagsPojo> tagsPojo;
	List<String> PhotoUrl;
	int id;
	
	@BeforeClass
	public void data()
	{
		faker = new Faker();
		payload = new PetPajo();
		payload.setId(69);
		
		//initialize category object
		objCate = new CategoryPojo();
		objCate.setId("10");
		objCate.setName("categoryname");
		payload.setCategory(objCate);
		
		payload.setName("Rocky");
		
		PhotoUrl = new ArrayList<String>();
		PhotoUrl.add("www.photo.com");
		
		payload.setPhotoUrls(PhotoUrl);
		
		//initialize  TagsPojo List Object
	    tagsPojo = new ArrayList<TagsPojo>();
		TagsPojo obj= new TagsPojo();
		obj.setId("6");
		obj.setName("tagname");
		tagsPojo.add(obj);
		
		
		payload.setTags(tagsPojo);
		
		payload.setStatus("available");
		
		id =payload.getId();
		
			
	}
	
	@Test(priority=1)
	public void cratePet()
	{
		
		Response response=	PetEndPoints.CreatePet(payload);
		Assert.assertEquals(response.statusCode(), 200,"Status Code not matching");
		Assert.assertEquals(response.header("Content-Type"),"application/json","header not matching");
		
		
	}
	

	@Test(priority=2)
	public void GetPet()
	{
		
		Response response=	PetEndPoints.GetPet(id);
		Assert.assertEquals(response.statusCode(), 200,"Status Code not matching");
		Assert.assertEquals(response.header("Content-Type"),"application/json","header not matching");
		
		
	}
	
	@Test(priority=3)
	public void UpdatePet()
	{
		
		Response response=	PetEndPoints.UpdatePet(id);
		Assert.assertEquals(response.statusCode(), 200,"Status Code not matching");
		Assert.assertEquals(response.header("Content-Type"),"application/json","header not matching");
		Assert.assertEquals(response.jsonPath().get("type"),"unknown");
		
		
	}

	@Test(priority=4)
	public void DeletePet()
	{
		
		Response response=	PetEndPoints.DeltePet(id);
		String idexpect=Integer.toString(id);
		Assert.assertEquals(response.statusCode(), 200,"Status Code not matching");
		Assert.assertEquals(response.header("Content-Type"),"application/json","header not matching");
		Assert.assertEquals(response.jsonPath().get("type"),"unknown");
		Assert.assertEquals(response.jsonPath().get("message"), idexpect);
		
		
	}
}
