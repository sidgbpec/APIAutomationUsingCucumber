package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.PojoforUpdatingARepo;

import static utilities.OutputValue.*;

import org.junit.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static utilities.Authentication.*;

public class Test_UpdateARepo 
{
	ObjectMapper objectMapper;
	public static String accountOwner;
	public static String nameOfRepo;
	String Token;
	String requestBodyForUpdation;
	Response responseOfUpdation;
	String descriptionBeforeUpdation;
	String descriptionAfterUpdation;
	
	@Given("repo is available i.e. account owner and repo name are available")
	public void repo_is_available_i_e_account_owner_and_repo_name_are_available() 
	{
		accountOwner=getValue(Test_CreateARepo.responseOfCreatingARepo, "owner.login");
		nameOfRepo=getValue(Test_CreateARepo.responseOfCreatingARepo, "name");
	}
	@Given("valid authentication token is available")
	public void valid_authentication_token_is_available() 
	{
		Token=getToken();
	}
	@When("user hit update endpoint URL")
	public void user_hit_update_endpoint_url() throws JsonProcessingException 
	{
		descriptionBeforeUpdation=getValue(Test_CreateARepo.responseOfCreatingARepo, "description");
		System.out.println("description before updation is "+descriptionBeforeUpdation);
		objectMapper=new ObjectMapper();
		PojoforUpdatingARepo data=new PojoforUpdatingARepo();
		data.setDescription("this is with cucumber");
		String endpointURLforUPdation="/repos/"+accountOwner+"/"+nameOfRepo;
		requestBodyForUpdation=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		responseOfUpdation=base.BaseClass.getResponseOfUpdateARepo(requestBodyForUpdation, Token, endpointURLforUPdation);
		descriptionAfterUpdation=getValue(responseOfUpdation, "description");
		System.out.println("description after updation is "+descriptionAfterUpdation);
	}
	@Then("fields should be updated")
	public void fields_should_be_updated() 
	{
		Assert.assertNotEquals(descriptionAfterUpdation, descriptionBeforeUpdation);
	}
}
