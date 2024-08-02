package com.yehorychev.stepDefinitions;

import com.yehorychev.pageObjects.LandingPage;
import com.yehorychev.pageObjects.OffersPage;
import com.yehorychev.pageObjects.PageObjectManager;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import utils.TestContextSetup;

public class OfferPageStepDefinitions {
    public String offerPageProductName;
    TestContextSetup testContextSetup;
    PageObjectManager pageObjectManager;

    public OfferPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("^User searched for (.+) shortname in offers page$")
    public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
        switchToOffersPage();
        OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
        offersPage.searchItem(shortName);
        offerPageProductName = offersPage.getProductName();
    }

    @Then("Validate product name in Offers Page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_landing_page() {
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
    }

    // --------------------------------------------------------------------------------------------

    public void switchToOffersPage() {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();

        if (!testContextSetup.driver.getCurrentUrl().equals(testContextSetup.genericUtils.
                getTargetURL("https://rahulshettyacademy.com/seleniumPractise/#/offers"))) {
            landingPage.selectTopDealsPage();
            testContextSetup.genericUtils.switchWindowToChild();
        }
    }
}
