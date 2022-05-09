package stepDefinition;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import io.cucumber.java.en.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.ConstantsMethods;
import resources.TestDataBuild;
import resources.Utils;

import static org.junit.Assert.*;

public class Login_SD extends Utils{
	RequestSpecification res;
	ResponseSpecification resp;
	Response response;
	static String place_id;
	TestDataBuild data=new TestDataBuild();
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String address, String lang) throws IOException {

		
		res=given().spec(requestSpecification())
				.body(data.addPlacePayload(name,address,lang));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource,String method) {
		
		ConstantsMethods resourceAPI=ConstantsMethods.valueOf(resource);
		resp =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST"))
		{
		response=res.when().post(resourceAPI.getresource());
		}
		else if(method.equalsIgnoreCase("DELETE"))
		{
		response=res.when().delete(resourceAPI.getresource());
		}
		else if(method.equalsIgnoreCase("GET"))
		{
		response=res.when().get(resourceAPI.getresource());
		}
		System.out.println(resourceAPI.getresource());
	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
	    
		assertEquals(response.getStatusCode(),200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyvalue, String Expectedvalue) {
	  
	    assertEquals(getJSONPATH(response,keyvalue),Expectedvalue);
	}
	@Then("Verify place ID created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String Expectedname, String resource) throws IOException {
		
		place_id=getJSONPATH(response,"place_id");
		res=given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource, "GET");
		String actualname=getJSONPATH(response,"name");
		assertEquals(actualname, Expectedname);
	}
	
	@Given("Deleteplace payload")
	public void deleteplace_payload() throws IOException {
		
		res=given().spec(requestSpecification())
				.body(data.DeletePlacePayload(place_id));
	}
}
