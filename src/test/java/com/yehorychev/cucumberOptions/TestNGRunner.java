package com.yehorychev.cucumberOptions;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/yehorychev/features",
        glue = "stepDefinitions", monochrome = true)
public class TestNGRunner {

}
