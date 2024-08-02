package com.yehorychev.stepDefinitions;

import com.yehorychev.pageObjects.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.TestContextSetup;

import java.io.IOException;

public class LandingPageStepDefinitions {
    TestContextSetup testContextSetup;
    public WebDriver driver;
    LandingPage landingPage;

    public LandingPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("User is on GreenKart Landing page")
    public void user_is_on_green_kart_landing_page() throws IOException {
        testContextSetup.driver = testContextSetup.testBase.webDriverManager();
        Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
    }

    @When("^User searched with shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        landingPage.searchItem(shortName);
        // WORK IN PROGRESS | Setup ExplicitWaits ->
        forceWaitUsingJavaScript(testContextSetup.driver, 2000);
        testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println(testContextSetup.landingPageProductName + " is extracted from Home Page");
    }

    @When("Added {string} items of the selected product to cart")
    public void added_items_of_the_selected_product_to_cart(String quantity) {
        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();
    }

    public void forceWaitUsingJavaScript(WebDriver driver, int milliseconds) {
        ((JavascriptExecutor) testContextSetup.driver).executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], " + milliseconds + ");");
    }
}
