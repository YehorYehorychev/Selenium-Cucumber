package com.yehorychev.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

public class Hooks {
    // This class handles post-test actions like tear down and capturing screenshots after failed steps.
    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @After
    public void tearDown() throws IOException, InterruptedException {
        testContextSetup.driver.quit();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            File sourcePath = ((TakesScreenshot) testContextSetup.driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image");
        }
    }
}
