package com.yehorychev.cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/yehorychev/features",
        glue = "com.yehorychev.stepDefinitions", monochrome = true,
        tags = "@@NetBanking or @Mortgage")
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
