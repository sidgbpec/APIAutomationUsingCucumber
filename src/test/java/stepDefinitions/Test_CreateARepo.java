package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.PojoforCreateARepo;

import static utilities.Authentication.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static base.BaseClass.*;

public class Test_CreateARepo 
{
	String Token;
	public static Response responseOfCreatingARepo;
	ObjectMapper objectMapper;
	int actualStatusCode;

	@Given("Valid token is there")
	public void valid_token_is_there() {
		Token = getToken();
		System.out.println("token is "+Token);
	}

	@When("User creates a new github repo")
	public void user_creates_a_new_github_repo() throws JsonProcessingException {
		objectMapper=new ObjectMapper();
		PojoforCreateARepo data = new PojoforCreateARepo();
		data.setName(data.getName() + Math.random());
		data.setDescription(data.getDescription() + Math.random());
		String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		System.out.println("request body is "+requestBody);
		responseOfCreatingARepo = getResponseOfCreateARepo(requestBody, Token, "/user/repos");
		System.out.println("response is "+responseOfCreatingARepo.asPrettyString());
		actualStatusCode = responseOfCreatingARepo.getStatusCode();
	}
	@Then("new repo should be created with unique id")
	public void new_repo_should_be_created_with_unique_id() {
		org.junit.Assert.assertEquals(201, actualStatusCode);
	}
}
