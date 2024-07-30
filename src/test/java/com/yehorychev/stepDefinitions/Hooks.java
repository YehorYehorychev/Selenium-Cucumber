package com.yehorychev.stepDefinitions;

import io.cucumber.java.After;
import utils.TestContextSetup;

import java.io.IOException;

public class Hooks {
    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @After
    public void tearDown() throws IOException, InterruptedException {
        testContextSetup.driver.quit();
    }
}
