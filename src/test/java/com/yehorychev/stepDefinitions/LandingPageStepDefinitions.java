package com.yehorychev.stepDefinitions;

import com.yehorychev.pageObjects.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestContextSetup;

import java.time.Duration;

public class LandingPageStepDefinitions {
    TestContextSetup testContextSetup;

    public LandingPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("User is on GreenKart Landing page")
    public void user_is_on_green_kart_landing_page() {
        WebDriverManager.chromedriver().setup();
        testContextSetup.driver = new ChromeDriver();
        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        testContextSetup.wait = new WebDriverWait(testContextSetup.driver, Duration.ofSeconds(10));
    }

    @When("User searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) {
        LandingPage landingPage = new LandingPage(testContextSetup.driver);
        landingPage.searchItem(shortName);

        testContextSetup.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()='Tomato - 1 Kg']")));

        testContextSetup.landingPageProductName =  testContextSetup.driver.findElement(By.xpath("//h4[normalize-space()='Tomato - 1 Kg']")).getText().split("-")[0].trim();
        System.out.println(testContextSetup.landingPageProductName + " is extracted from Home Page");
    }
}
