Feature: User Registration and Login

  @registration
  Scenario: Register, logout and login again with the same email

    Given I am on the Automation Exercise website
    When I navigate to the Signup and Login page
    And I register a new account with name "Danny" and a generated email
    And I complete the account information
    Then I should be logged in successfully
    When I logout from the account
    And I login again using the same email and password
    Then I should be logged in successfully again
    
    
    