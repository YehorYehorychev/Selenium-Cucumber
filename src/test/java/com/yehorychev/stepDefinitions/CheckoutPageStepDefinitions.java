package com.yehorychev.stepDefinitions;

import com.yehorychev.pageObjects.CheckoutPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.TestContextSetup;

public class CheckoutPageStepDefinitions {
    public WebDriver driver;
    public CheckoutPage checkoutPage;
    TestContextSetup testContextSetup;

    public CheckoutPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout_and_validate_the_tom_items_in_checkout_page(String expectedProductName) throws InterruptedException {
        checkoutPage.checkoutItems();
        String actualProductName = checkoutPage.getProductName();
        Assert.assertEquals(actualProductName, expectedProductName, "Product name does not match!");
    }

    @Then("Verify that the user has ability to enter promo code and place the order")
    public void verify_that_the_user_has_ability_to_enter_promo_code_and_place_the_order() {
        Assert.assertTrue(checkoutPage.verifyPromoButton());
        Assert.assertTrue(checkoutPage.verifyPlaceOrder());
    }
}
