package com.yehorychev.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class MainSteps {
    @Given("User is on NetBanking landing page")
    public void user_is_on_net_banking_landing_page() {
        System.out.println("User landed on NetBanking page");
    }

    @When("User login into application with {string} and password {string}")
    public void user_login_into_application_with_and_password(String username, String password) {
        System.out.printf(username + " and password is: " + password);
    }

    @When("User login into application with {string} and password {string} combination")
    public void user_login_into_application_with_and_password_combination(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        System.out.printf(username + " and password is: " + password);
    }

    @Then("Home Page is displayed")
    public void home_page_is_displayed() {
        System.out.println("");
        System.out.println("Home Page is displayed");
    }

    @Then("Cards are displayed")
    public void cards_are_displayed() {
        System.out.println("Cards are displayed");
    }
}
