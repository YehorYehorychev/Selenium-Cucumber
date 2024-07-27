package com.yehorychev.stepDefinitions;

import com.yehorychev.pageObjects.OffersPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinitions {
    public String offerPageProductName;
    TestContextSetup testContextSetup;

    public OfferPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("User searched for {string} shortname in offers page")
    public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
        switchToOffersPage();
        OffersPage offersPage = new OffersPage(testContextSetup.driver);
        offersPage.searchItem(shortName);
        testContextSetup.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tr td:nth-child(1)")));
        offerPageProductName = offersPage.getProductName();
    }

    @Then("Validate product name in Offers Page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_landing_page() {
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
        System.out.println("******** Landing page product name is: " + testContextSetup.landingPageProductName +
                " ******* Offers Page product name is: " + offerPageProductName);
    }

    public void switchToOffersPage() {
        String currentUrl = testContextSetup.driver.getCurrentUrl();
        String targetUrl = "https://rahulshettyacademy.com/seleniumPractise/#/offers";

        if (!currentUrl.equals(targetUrl)) {
            testContextSetup.driver.findElement(By.xpath("//a[normalize-space()='Top Deals']")).click();

            Set<String> windowHandles = testContextSetup.driver.getWindowHandles();
            Iterator<String> iterator = windowHandles.iterator();

            String parentWindow = iterator.next();
            String childWindow = iterator.next();

            testContextSetup.driver.switchTo().window(childWindow);
        }
    }
}
