package com.yehorychev.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) {
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        String productName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
        System.out.println(productName + " is extracted from Home Page");
    }

    @Then("User searched for the same shortname in offers page to check if product exist")
    public void user_searched_for_the_same_shortname_in_offers_page_to_check_if_product_exist() {
        // Write code here that turns the phrase above into concrete actions
    }
}
