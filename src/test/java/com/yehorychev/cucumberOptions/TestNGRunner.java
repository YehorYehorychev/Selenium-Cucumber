package com.yehorychev.cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/yehorychev/features", dryRun = false,
        glue = "com.yehorychev.stepDefinitions", monochrome = true,
        tags = "",
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"})
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
