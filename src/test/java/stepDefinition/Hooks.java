package stepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	Login_SD payload=new Login_SD();
	@Before("@Deleteplace")
	public void beforescenerio() throws IOException
	{
		//execute this code that will give you place id
		//execute this code only when place id is null
		if(Login_SD.place_id==null)
		{
		payload.add_place_payload_with("seema", "nepal", "nepali");
		payload.user_calls_with_http_request("AddPlaceAPI", "POST");
		payload.verify_place_id_created_maps_to_using("seema", "GetPlaceAPI");
		}
		}
}
