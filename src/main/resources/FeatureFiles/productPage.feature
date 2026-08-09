Feature: Product functionality

 @registration
  Scenario: Verify all products are visible
  
    Given I am on the Automation Exercise website
    When I navigate to the Products page
    Then I should see all products displayed


  @registration
  Scenario: Open first product and close advertisement
  
    Given I am on the Automation Exercise website
    When I navigate to the Products page
    And I click on the first product
    And I close the advertisement on the product page
    Then the product details page should be displayed