package com.yehorychev.stepDefinitions;

import com.yehorychev.pageObjects.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.GenericUtils;
import utils.TestContextSetup;

import java.io.IOException;

public class LandingPageStepDefinitions extends GenericUtils {
    private static final Logger log = LogManager.getLogger(LandingPageStepDefinitions.class);
    TestContextSetup testContextSetup;
    public WebDriver driver;
    LandingPage landingPage;

    public LandingPageStepDefinitions(TestContextSetup testContextSetup) {
        super(testContextSetup.driver);
        this.testContextSetup = testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("User is on GreenKart Landing page")
    public void user_is_on_green_kart_landing_page() throws IOException {
        log.info("Navigating to GreenKart Landing page");
        String pageTitle = landingPage.getTitleLandingPage();
        log.info("Page title is: {}", pageTitle);
        testContextSetup.driver = testContextSetup.testBase.webDriverManager();
        Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
        log.info("User is on GreenKart Landing page successfully");
    }

    @When("^User searched with shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        log.info("Searching for product with shortname: {}", shortName);
        landingPage.searchItem(shortName);
        waitForFixedAmountOfTime(testContextSetup.driver, 2000);
        testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
        log.info("Extracted product name: {}", testContextSetup.landingPageProductName);
    }

    @When("Added {string} items of the selected product to cart")
    public void added_items_of_the_selected_product_to_cart(String quantity) {
        log.info("Adding {} items of the selected product to cart", quantity);
        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();
        log.info("Items added to cart successfully");
    }
}
