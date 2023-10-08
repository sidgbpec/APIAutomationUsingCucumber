package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static utilities.Authentication.*;
import static utilities.OutputValue.*;
import static base.BaseClass.*;

public class Test_DeleteARepo {
	String Token;
	String endpointURLForDeletion;
	String accountOwner;
	String nameOfRepo;
	Response responseOfDeletingARepo;
	
	@Given("a valid authentication token exist")
	public void a_valid_authentication_token_exist() {
		Token=getToken();
	}
	@Given("a valid repo exist")
	public void a_valid_repo_exist() {
	  accountOwner=getValue(Test_ReadingARepo.responseOfReading, "owner.login");
	  nameOfRepo=getValue(Test_ReadingARepo.responseOfReading, "name");
	}
	@When("user hit deleteARepo URL")
	public void user_hit_delete_a_repo_url() {
		endpointURLForDeletion="/repos/"+accountOwner+"/"+nameOfRepo;
	  responseOfDeletingARepo=getResponseOfDeletingARepo(Token, endpointURLForDeletion);
	}
	@Then("user should be able to delete the repo")
	public void user_should_be_able_to_delete_the_repo() {
	  int actualStatusCodeOfDeletion=responseOfDeletingARepo.getStatusCode();
	  org.junit.Assert.assertEquals(204, actualStatusCodeOfDeletion);
	}
}
