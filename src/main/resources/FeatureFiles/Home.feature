Feature: Home Page Functionality

  Background:
    Given I am on the Automation Exercise website

  @home @smoke
  Scenario: Verify home page is displayed
    Then home page should be displayed successfully

  @home
  Scenario: Verify website logo is displayed
    Then Automation Exercise logo should be visible

  @home
  Scenario: Verify navigation menu is displayed
    Then navigation menu should be displayed

  @home
  Scenario: Navigate to Products page from home page
    When user clicks on Products menu
    Then products page should be displayed

  @home
  Scenario: Navigate to Cart page from home page
    When user clicks on Cart menu
    Then cart page should be displayed

  @home
  Scenario: Navigate to Signup Login page
    When user clicks on Signup Login menu
    Then login page should be displayed

  @home
  Scenario: Verify subscription section
    Then subscription section should be displayed

  @home
  Scenario: Verify footer is displayed
    Then footer should be displayed