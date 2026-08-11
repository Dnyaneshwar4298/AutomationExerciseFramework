package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "/Users/danny/Documents/CopyOfMyProject/src/main/resources/FeatureFiles/",
    glue = "stepdefinations",

    dryRun = true,
    plugin = {
            "pretty",
            "html:target/cucumber-report.html",
            "json:target/cucumber.json"
        }
   )

public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

//@CucumberOptions(//allows you to configure Cucumber.

//features //This tells Cucumber where your .feature files are located.
//glue : must match the package.My Step Definition classes are inside the stepDefinitions package."
// tags : //Run only scenarios having the @registration tag."
//pretty:Makes the console output easier to read.
// html: Cucumber creates an HTML report here: