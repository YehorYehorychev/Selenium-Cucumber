package com.yehorychev.stepDefinitions;

import com.yehorychev.pageObjects.CheckoutPage;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.TestContextSetup;

public class CheckoutPageStepDefinitions {
    private static final Logger log = LogManager.getLogger(CheckoutPageStepDefinitions.class);
    public WebDriver driver;
    public CheckoutPage checkoutPage;
    TestContextSetup testContextSetup;

    public CheckoutPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout_and_validate_the_tom_items_in_checkout_page(String expectedProductName) throws InterruptedException {
        log.info("Proceeding to checkout and validating the items in checkout page");
        checkoutPage.checkoutItems();
        String actualProductName = checkoutPage.getProductName();
        log.info("Actual product name in checkout: {}", actualProductName);
        Assert.assertEquals(actualProductName, expectedProductName, "Product name does not match!");
        log.info("Product name validation successful");
    }

    @Then("Verify that the user has ability to enter promo code and place the order")
    public void verify_that_the_user_has_ability_to_enter_promo_code_and_place_the_order() {
        log.info("Verifying the presence of promo code button and place order button");
        Assert.assertTrue(checkoutPage.verifyPromoButton());
        log.info("Promo code button is present");
        Assert.assertTrue(checkoutPage.verifyPlaceOrder());
        log.info("Place order button is present");
    }
}
