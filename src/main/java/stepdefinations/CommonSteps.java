package stepdefinations;

import io.cucumber.java.en.Given;

public class CommonSteps {

    @Given("I am on the Automation Exercise website")
    public void userOpensAutomationExerciseWebsite() {

        System.out.println("Automation Exercise website opened");
    }
}