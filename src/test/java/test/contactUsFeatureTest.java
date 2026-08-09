package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.baseClass;
import keywords.browserKeywords;
import pages.homePage;
import utility.ConfigReader;

public class contactUsFeatureTest extends baseClass {

    @Test
    public void fillContactUsForm() {

        homePage homePage = new homePage();

        homePage.fillContactUsForm(
                ConfigReader.getProperty("contactName"),
                "contact" + System.currentTimeMillis() + "@gmail.com",
                ConfigReader.getProperty("contactSubject"),
                ConfigReader.getProperty("contactMessage"),
                ConfigReader.getOptionalProperty("uploadFilePath")
        );

        Assert.assertEquals(
                homePage.getResponseMessage(),
                "Success! Your details have been submitted successfully."
        );

        System.out.println("Contact form submitted successfully");
        System.out.println("Current URL: " + browserKeywords.getCurrentUrl());
    }
}
