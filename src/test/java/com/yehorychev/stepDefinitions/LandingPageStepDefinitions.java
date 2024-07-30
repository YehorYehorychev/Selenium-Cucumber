package com.yehorychev.stepDefinitions;

import com.yehorychev.pageObjects.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.TestContextSetup;

import java.io.IOException;

public class LandingPageStepDefinitions {
    TestContextSetup testContextSetup;

    public LandingPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("User is on GreenKart Landing page")
    public void user_is_on_green_kart_landing_page() throws IOException {
        testContextSetup.driver = testContextSetup.testBase.webDriverManager();
    }

    @When("User searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.searchItem(shortName);

        testContextSetup.testBase.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()='Tomato - 1 Kg']")));

        testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println(testContextSetup.landingPageProductName + " is extracted from Home Page");
    }
}
