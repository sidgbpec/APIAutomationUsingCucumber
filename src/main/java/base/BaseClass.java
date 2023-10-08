package base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static utilities.BaseURL.*;
public class BaseClass {

	public static String baseURI=getBaseURL();
	public static Response getResponseOfCreateARepo(String requestBody, String Token, String endpointURL)
	{
		RestAssured.baseURI=baseURI;
		RequestSpecification reqspec=RestAssured.given().body(requestBody);
		reqspec.header("Authorization", "Bearer "+Token);
		reqspec.header("Accept", "application/vnd.github+json");
		Response response=reqspec.when().post(endpointURL).then().extract().response();
		return response;
	}
	
	public static Response getResponseOfUpdateARepo(String requestBody, String Token, String endpointURL)
	{
		RestAssured.baseURI=baseURI;
		RequestSpecification reqspec=RestAssured.given().body(requestBody);
		reqspec.header("Authorization", "Bearer "+Token);
		reqspec.header("Accept", "application/vnd.github+json");
		Response response=reqspec.when().patch(endpointURL).then().extract().response();
		return response;
	}
	
	public static Response getResponseOfReadingARepo(String Token, String endpointURL)
	{
		RestAssured.baseURI=baseURI;
		RequestSpecification reqspec=RestAssured.given();
		reqspec.header("Authorization", "Bearer "+Token);
		reqspec.header("Accept", "application/vnd.github+json");
		Response response=reqspec.when().get(endpointURL).then().extract().response();
		return response;
	}
	
	public static Response getResponseOfDeletingARepo(String Token, String endpointURL)
	{
		RestAssured.baseURI=baseURI;
		RequestSpecification reqspec=RestAssured.given();
		reqspec.header("Authorization", "Bearer "+Token);
		reqspec.header("Accept", "application/vnd.github+json");
		Response response=reqspec.when().delete(endpointURL).then().extract().response();
		return response;
	}
}
