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


Scenario: Search for a product
    Given I am on the Automation Exercise website
    When I navigate to the Products page
    And I search for "Blue Top"
    Then I should see products matching "Blue Top"


Scenario: Add a product to cart
    Given I am on the Automation Exercise website
    When I navigate to the Products page
    And I add "Blue Top" to the cart
    Then the product "Blue Top" should be displayed in the cart


Scenario: Add multiple products to cart
    Given I am on the Automation Exercise website
    When I navigate to the Products page
    And I add multiple products to the cart
    Then all selected products should be displayed in the cart


Scenario: Remove a product from cart
    Given I am on the Automation Exercise website
    When I navigate to the Products page
    And I have a product "Blue Top" in the cart
    When I remove the product
    Then the product should no longer be displayed in the cart


Scenario: Verify cart product price and total
    Given I am on the Automation Exercise website
    When I navigate to the Products page
    And I have products in the cart
    Then the product prices should be displayed correctly
    And the total price should be calculated correctly


Scenario: Verify product details
    Given I am on the Automation Exercise website
    When I navigate to the Products page
    And I open a product
    Then I should see all product details