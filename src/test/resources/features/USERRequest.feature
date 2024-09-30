Feature: Add New User [Post Operation]

Background:
 Given User sets the Basic authorization with "Username" and "Password"
  
 @GETAllUser
 Scenario Outline: Get all users with valid endpoint and method 
    Given User creates GET request  
    When User sends GET with "<endPoint>"
    Then User should receives <status> 
 Examples:
    | endPoint  | status |
    | /users    | 200    |
    | /user     | 404    |
    | /         | 404    |
    
 @POSTCreateUser 
 Scenario: Create new User with all valid field values
    Given User set POST for user API Endpoint  
    When User sends Post Request with valid End Point and valid data
    Then User should receive 201 created
    
 @PostMandatoryFieldCreateUser  
 Scenario: Create new User with all valid field values
    Given User set POST for user API Endpoint  
    When User sends Post Request with valid End Point and Mandatory data
    Then User should receive 201 created
         
  @PUTUpdateuser  
 Scenario: Validate if the User update is done with all valid fields
    Given Put Request created with valid endpoint: updateuser userId  
    When User sends Put Request with valid End Point and valid data
    Then A valid response is received and User is updated with status code 200   
    
  @GETUser_ResponseUserId  
 Scenario: Get user information by  user id
    Given User creates GET request from response  
    When User sends GET request with valid User Id endpoint
    Then User details are displayed with status code 200 OK
    
  @GETUser_ResponseUserName
    Scenario: Get user information by  user first name
    Given User creates GET request from response  
    When User sends GET request with valid user name endpoint
    Then User details are displayed with status code 200 OK
    
  @GETUser_UserId
   Scenario Outline: Get user information by  user id
    Given User creates GET request  
    When User sends GET with "<endPoint>"
    Then User details are displayed with status code <status> OK 
    Examples:
    
    | endPoint                         | status |
    | user/1122                        | 200    |
    | user/user                        | 400    |
    | /                                | 404    |   
      
  @GETUser_UserFirstName  
Scenario Outline: Get all users with valid endpoint and method 
    Given User creates GET request  
    When User sends GET with "<endPoint>"
    Then User should receives <status>
   Examples:
    | endPoint                         | status |
    | users/username/kikiki            | 200    |
    | users/username/1112              | 404    |
    | /                                | 404    |     

 @DELETEUserFromUserName    
 Scenario Outline: Delete users with username 
    Given User creates DELETE request  
    When User sends DELETE with "<endPoint>"
    Then User should receives <status> 
   Examples:
    | endPoint                         | status |
    | /deleteuser/username/kikiki      | 200    |
    | /deleteuser/username/1112        | 404    |
    | /                                | 404    |    
 #
