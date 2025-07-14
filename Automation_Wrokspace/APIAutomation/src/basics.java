import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;


import files.ReUsabelMethods;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

public class basics {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Validate if add place API is working as expected
		//given- all input details
		//when - submit an API- resource and method
		//then - validate the response
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\suman\\AddPlace.json"))))
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println("Response is :"+response);
		
		JsonPath js = new JsonPath(response);
		String placeid= js.getString("place_id");
		System.out.println(placeid);
		
		//update place
		String newAddress = "2233 Summer Line, Africa";
		
		given().log().all().queryParam("key", "qaclick123").header("content-Type","application/json")
		.body("{\r\n"
				+ "    \"place_id\": \""+placeid+"\",\r\n"
				+ "    \"address\":\""+newAddress+"\",\r\n"
				+ "    \"key\":\"qaclick123\"\r\n"
				+ "    \r\n"
				+ "}")
		.when().put("/maps/api/place/update/json")
		.then().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		
		//get place
		String getPlaceResonse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
		.when().get("/maps/api/place/get/json")
		.then().statusCode(200)
		.extract().response().asString();
		
		JsonPath jp = ReUsabelMethods.rawToJson(getPlaceResonse);
		String actualAddress = jp.getString("address");
		Assert.assertEquals(actualAddress, newAddress); //Assertion to check actual address vs new address
				
		
		
	}

}
