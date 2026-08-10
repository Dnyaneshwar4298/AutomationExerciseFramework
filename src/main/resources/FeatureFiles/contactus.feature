Feature: Contact Us Form

  Scenario: Submit contact us form successfully
    Given I am on the Automation Exercise website
    When I fill the Contact Us form with valid details and I submit the Contact Us form
    Then I should see the contact form success message
    
    
