package com.yehorychev.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKartStepDefinitions {
    WebDriver driver;

    @Given("User is on GreenKart Landing page")
    public void user_is_on_green_kart_landing_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("User searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String string) {

    }

    @Then("User searched for the same shortname in offers page to check if product exist")
    public void user_searched_for_the_same_shortname_in_offers_page_to_check_if_product_exist() {
        // Write code here that turns the phrase above into concrete actions
    }
}
