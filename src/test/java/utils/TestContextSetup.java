package utils;

import com.yehorychev.pageObjects.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestContextSetup {
    public WebDriver driver;
    public String landingPageProductName;
    public WebDriverWait wait;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;

    public TestContextSetup() {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
    }
}
