package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException
	{
		if(req==null)
		{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		req=new RequestSpecBuilder()
				.setBaseUri(getproperty("baseurl"))
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		return req;
		}
		return req;
	}
	public String getproperty(String key) throws IOException
	{
		
			Properties prop= new Properties();
			FileInputStream fis=new FileInputStream("C:\\Users\\Pooja Singh\\eclipse-workspace\\Cucumber_API\\src\\test\\java\\resources\\config.properties");
			prop.load(fis);
			String value=prop.getProperty(key);
			return value;
	}
	public String getJSONPATH(Response response,String key)
	{
		String respo=response.asString();
	    JsonPath js=new JsonPath(respo);
	    return  js.get(key).toString();
	}
}
