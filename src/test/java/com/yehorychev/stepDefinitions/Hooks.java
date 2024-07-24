package com.yehorychev.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before("@NetBanking")
    public void netBankingSetup() {
        System.out.println("Setup the entries in NetBank database");
    }

    @After
    public void tearDown() {
        System.out.println("Clear the entries");
    }

    @Before("@Mortgage")
    public void mortgageSetup() {
        System.out.println("Setup the entries in Mortgage database");
    }
}
