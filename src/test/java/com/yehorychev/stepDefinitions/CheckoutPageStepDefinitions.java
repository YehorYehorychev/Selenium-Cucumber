package com.yehorychev.stepDefinitions;

import com.yehorychev.pageObjects.LandingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.TestContextSetup;

import java.io.IOException;

public class CheckoutPageStepDefinitions {
    TestContextSetup testContextSetup;

    public CheckoutPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("Verify that the user has ability to enter promo code and place the order")
    public void verify_that_the_user_has_ability_to_enter_promo_code_and_place_the_order() {

    }
}
