package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static utilities.Authentication.*;

import org.junit.Assert;

import static base.BaseClass.getResponseOfReadingARepo;
import static utilities.OutputValue.*;
public class Test_ReadingARepo {
	String Token;
	String endpointURLForReading;
	public static Response responseOfReading;
	
	String accountOwner;
	String nameOfRepo;
	
	@Given("valid authentication token exist")
	public void valid_authentication_token_exist() {
		Token=getToken();
	}
	@Given("valid repo exist")
	public void valid_repo_exist() {
	accountOwner=getValue(Test_CreateARepo.responseOfCreatingARepo, "owner.login");
	nameOfRepo=getValue(Test_CreateARepo.responseOfCreatingARepo, "name");
	}
	@When("user hit readARepo URL")
	public void user_hit_read_a_repo_url() {
	   endpointURLForReading="/repos/"+accountOwner+"/"+nameOfRepo;
	   responseOfReading=getResponseOfReadingARepo(Token, endpointURLForReading);
	    
	}
	@Then("user should be able to read complete repo")
	public void user_should_be_able_to_read_complete_repo() {
	   System.out.println(responseOfReading.asPrettyString());
	   Assert.assertNotNull(responseOfReading);
	}
}
