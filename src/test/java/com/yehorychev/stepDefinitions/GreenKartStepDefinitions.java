package com.yehorychev.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class GreenKartStepDefinitions {
    WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;
    WebDriverWait wait;

    @Given("User is on GreenKart Landing page")
    public void user_is_on_green_kart_landing_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("User searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()='Tomato - 1 Kg']")));
        landingPageProductName = driver.findElement(By.xpath("//h4[normalize-space()='Tomato - 1 Kg']")).getText().split("-")[0].trim();
        System.out.println(landingPageProductName + " is extracted from Home Page");
    }

    @Then("User searched for {string} shortname in offers page")
    public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Top Deals']")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tr td:nth-child(1)")));
        offerPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
    }

    @Then("Validate product name in Offers Page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_landing_page() {
        Assert.assertEquals(offerPageProductName, landingPageProductName);
        System.out.println("******** Landing page product name is: " + landingPageProductName +
                " ******* Offers Page product name is: " + offerPageProductName);
    }
}
