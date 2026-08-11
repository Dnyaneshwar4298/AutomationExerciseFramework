package stepdefinations;

import io.cucumber.java.en.Given;
import keywords.browserKeywords;

public class CommonSteps {

    @Given("I am on the Automation Exercise website")
    public void userOpensAutomationExerciseWebsite() {

        browserKeywords.getDriver()
                .get("https://automationexercise.com/");
    }


    @Given("user launches the Automation Exercise website")
    public void userLaunchesTheAutomationExerciseWebsite() {

        browserKeywords.getDriver()
                .get("https://automationexercise.com/");
    }
}