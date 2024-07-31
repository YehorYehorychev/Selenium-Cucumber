package com.yehorychev.stepDefinitions;

import com.yehorychev.pageObjects.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.TestContextSetup;

import java.io.IOException;

public class LandingPageStepDefinitions {
    TestContextSetup testContextSetup;
    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;
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
        Thread.sleep(3000);
        testContextSetup.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()='Tomato - 1 Kg']")));
        testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println(testContextSetup.landingPageProductName + " is extracted from Home Page");
    }

    @When("Added {string} items of the selected product to cart")
    public void added_items_of_the_selected_product_to_cart(String quantity) {
        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();
    }
}
