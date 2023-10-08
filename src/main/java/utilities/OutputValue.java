package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class OutputValue 
{
	public static String getValue(Response response, String key)
	{
		JsonPath jp=new JsonPath(response.asString());
		return jp.getString(key);
	}
}
