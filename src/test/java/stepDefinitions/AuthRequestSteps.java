package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.configReader;
import static io.restassured.RestAssured.*;
import java.util.Properties;


public class AuthRequestSteps {
	private Response response;
	private RequestSpecification request; 
	configReader config=new configReader();
	Properties prop=config.initprop();
	
	@Given("User sets the Basic authorization with {string} and {string}")
	public void user_sets_the_basic_authorization_with_and(String user, String pass) {
		
		RestAssured.baseURI=prop.getProperty("baseUrl");
		user=prop.getProperty("username");
		pass=prop.getProperty("password");
		RestAssured.authentication = RestAssured.basic(user, pass);
//		request=given().auth() // authentication 
//            .basic(user,pass);
	}
}
	
	


