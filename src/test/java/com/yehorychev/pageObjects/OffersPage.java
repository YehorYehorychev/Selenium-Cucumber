package com.yehorychev.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GenericUtils;

import java.time.Duration;

public class OffersPage extends GenericUtils {
    public WebDriver driver;
    private WebDriverWait wait;

    public OffersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchInput;

    @FindBy(css = "tr td:nth-child(1)")
    private WebElement productName;

    public void searchItem(String shortName) {
        waitForElementToBeVisible(searchInput).sendKeys(shortName);
    }

    public void getSearchItem() {
        waitForElementToBeVisible(searchInput).getText();
    }

    public String getProductName() {
        return waitForElementToBeVisible(productName).getText();
    }
}