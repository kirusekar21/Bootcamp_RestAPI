package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.payload;
import pojo.User;

import static io.restassured.RestAssured.*;

import com.fasterxml.jackson.core.JsonProcessingException;
public class RequestSteps {
	payload pl=new payload();
	private String userid;
	private String userName;
	String expectedFirstName=pl.postBody().getUser_first_name();
	private Response response;
	private RequestSpecification request;
//	user get all user
	@Given("User creates GET request")
	public void user_creates_get_request() {
	    request=given();
	}

	@When("User sends GET with {string}")
	public void user_sends_with(String endpoint) {
		 response = request.log().all()
				           .when().get(endpoint);
		 System.out.println("Response Status Code: " + response.getStatusCode());
		 System.out.println("Response Body: " + response.getBody().asString());
	}
	 @Then("User should receives {int}")
	    public void user_should_receives(int status) {
	        // Assert that the response has the expected status code
	        response.then()
	                .assertThat()
	                .statusCode(status).header("Content-Type", "application/json");
	        
	        // Optionally log the response body for debugging
	        System.out.println("Response Body: " + response.getBody().asString());
	    }
	 
//	  post request create user 
	@Given("User set POST for user API Endpoint")
	public void user_set_post_for_user_api_endpoint_createusers() {
		request=given().log().all();
	}
    @When("User sends Post Request with valid End Point and valid data")
	public void user_sends_post_request_with_and() {
	   response=request.log().all().contentType(ContentType.JSON).when()
			    .body(pl.postBody()).post("/createusers");
	}

	@Then("User should receive {int} created")
	public void user_should_receive(int status) {
	        response.then().assertThat()
                           .statusCode(status);
	   userid=response.jsonPath().getString("user_id");
	   userName=response.jsonPath().getString("user_first_name");
	  
	   System.out.println("User ID: " + userid);
	   System.out.println("User Name is:"+userName);
	   assert userName.equals(expectedFirstName) : "Expected first name does not match";
	   User.getInstance().setuser_id(userid);
	   User.getInstance().setUser_first_name(userName);
	 }
//	post_Mandatory_Field

@When("User sends Post Request with valid End Point and Mandatory data")
public void user_sends_post_request_with_valid_end_point_and_mandatory_data() throws JsonProcessingException {
	response=request.log().all().contentType(ContentType.JSON).when().body(pl.postOnlyMandatoryField()).post("/createusers"); 
}
//	 put request
	
	@Given("Put Request created with valid endpoint: updateuser userId")
	public void put_request_created_with_valid_endpoint_updateuser() {
		request=given().log().all();
	}

	@When("User sends Put Request with valid End Point and valid data")
	public void user_sends_put_request_with_valid_end_point_and_valid_data() {
		userid=User.getInstance().getuser_id();
		response=request.log().all().contentType(ContentType.JSON).when().body(pl.putBody()).put("updateuser/"+userid);
	}

	@Then("A valid response is received and User is updated with status code {int}")
	public void a_valid_response_is_received_and_user_is_updated_with_status_code(int status) {
		response.then().assertThat().statusCode(status);
	}

	
	
//	GET user id from response and getting 
	@Given("User creates GET request from response")
	public void user_creates_get_request_from_response() {
	    request=given().log().all();
	    
	}
	
	@When("User sends GET request with valid User Id endpoint")
	public void user_sends_get_request_with_valid_User_Id_endpoint() {
//		get user id from body just posted
//		this.userid=userid;
		 userid=User.getInstance().getuser_id();
		 System.out.println(userid);
		 response = request.log().all()
		            .when().get("/user/" + userid);
		       
		}
//		 response=request.log().all().contentType(ContentType.JSON).when().get("/user"+"/4996");	
	
	
    @Then("User details are displayed with status code {int} OK")
	public void user_details_are_displayed_with_status_code_ok(int status) {
    	
    	System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.asString());
    	
    	 response.then()
        .assertThat()
        .statusCode(status).header("Content-Type", "application/json");
//		assert userName.equals(expectedFirstName) : "Expected first name does not match";
	}
    
    // get user from response user name
    @When("User sends GET request with valid user name endpoint")
	public void user_sends_get_request_with_valid_user_name_endpoint() {
//		get user id from body just posted
//		this.userid=userid;
		 userName=User.getInstance().getUser_first_name();
		 System.out.println(userName);
		 response = request.log().all()
		            .when().get("/users/username/"+ userName);
		       
		}
    
//    Delete user 
    @Given("User creates DELETE request")
    public void user_creates_delete_request() {
    	request=given().log().all();
    }

    @When("User sends DELETE with {string}")
    public void user_sends_delete_with(String delEndpoint) {
    	response=request.log().all()
	    		.contentType(ContentType.JSON)
	    		.when().delete(delEndpoint);
	    System.out.println("GET Response: " + response.asString());
//		 response=request.log().all().contentType(ContentType.JSON).when().get("/user"+"/4996");
	}
    
	
}
//4996

