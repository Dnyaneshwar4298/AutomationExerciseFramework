package stepdefinations;

import org.testng.Assert;

import base.baseClass;
import pages.HomePage;
import utility.ConfigReader;


import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ContactUsStepDefinition extends baseClass {

    private HomePage homePage;


    @When("I fill the Contact Us form with valid details and I submit the Contact Us form")
    public void i_fill_the_contact_us_form_with_valid_details() {

        homePage.fillContactUsForm(
                ConfigReader.getProperty("contactName"),
                "contact" + System.currentTimeMillis() + "@gmail.com",
                ConfigReader.getProperty("contactSubject"),
                ConfigReader.getProperty("contactMessage"),
                ConfigReader.getOptionalProperty("uploadFilePath")
        );
    }


    @Then("I should see the contact form success message")
    public void i_should_see_the_contact_form_success_message() {

        Assert.assertEquals(
                homePage.getResponseMessage(),
                "Success! Your details have been submitted successfully."
        );

        System.out.println("Contact form submitted successfully");
    }
}