package com.yehorychev.stepDefinitions;

import com.yehorychev.pageObjects.LandingPage;
import com.yehorychev.pageObjects.OffersPage;
import com.yehorychev.pageObjects.PageObjectManager;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import utils.TestContextSetup;

public class OfferPageStepDefinitions {
    private static final Logger log = LogManager.getLogger(OfferPageStepDefinitions.class);
    public String offerPageProductName;
    TestContextSetup testContextSetup;
    PageObjectManager pageObjectManager;

    public OfferPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("^User searched for (.+) shortname in offers page$")
    public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
        log.info("User searching for product with shortname: {} in Offers Page", shortName);
        switchToOffersPage();
        OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
        offersPage.searchItem(shortName);
        offerPageProductName = offersPage.getProductName();
        log.info("Product name extracted from Offers Page: {}", offerPageProductName);
    }

    @Then("Validate product name in Offers Page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_landing_page() {
        log.info("Validating product name in Offers Page matches with Landing Page");
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
        log.info("Product name validation successful. Offer page: {}, Landing page: {}",
                offerPageProductName, testContextSetup.landingPageProductName);
    }

    // --------------------------------------------------------------------------------------------

    public void switchToOffersPage() {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        String currentUrl = testContextSetup.driver.getCurrentUrl();
        String targetUrl = testContextSetup.genericUtils.getTargetURL("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        if (!currentUrl.equals(targetUrl)) {
            log.info("Switching to Offers Page from current URL: {}", currentUrl);
            landingPage.selectTopDealsPage();
            testContextSetup.genericUtils.switchWindowToChild();
            log.info("Switched to Offers Page");
        } else {
            log.info("Already on Offers Page");
        }
    }
}
