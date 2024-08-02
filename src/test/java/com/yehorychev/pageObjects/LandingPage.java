package com.yehorychev.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {
    public WebDriver driver;
    private WebDriverWait wait;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//h4[normalize-space()='Tomato - 1 Kg']")
    private WebElement productName;

    @FindBy(xpath = "//a[normalize-space()='Top Deals']")
    private WebElement topDeals;

    @FindBy(css = ".product-action button")
    private WebElement addToCartButton;

    @FindBy(css = "a.increment")
    private WebElement incrementButton;

    public void searchItem(String shortName) {
        wait.until(ExpectedConditions.visibilityOf(searchInput)).sendKeys(shortName);
    }

    public void getSearchItem() {
        wait.until(ExpectedConditions.visibilityOf(searchInput)).getText();
    }

    public void incrementQuantity(int quantity) {
        int i = quantity - 1;
        while (i > 0) {
            wait.until(ExpectedConditions.elementToBeClickable(incrementButton)).click();
            i--;
        }
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOf(productName)).getText();
    }

    public void selectTopDealsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(topDeals)).click();
    }

    public String getTitleLandingPage() {
        return driver.getTitle();
    }
}