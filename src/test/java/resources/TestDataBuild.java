package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	public AddPlace addPlacePayload(String name,String address,String lang)
	{
		AddPlace ap=new AddPlace();
		ap.setAccuracy(50);
		ap.setAddress(address);
		ap.setLanguage(lang);
		ap.setPh_no("(+91) 983 893 3937");
		ap.setName(name);
		ap.setWebsite("http://google.com");
		
		List<String> mylist=new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");
		ap.setTypes(mylist);
		
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ap.setLocation(l);
		
		return ap;
	}
	public String DeletePlacePayload(String placeid)
	{
		return "{\r\n"
				+ "    \"place_id\":\""+placeid+"\"\r\n"
				+ "}";
	}
}
