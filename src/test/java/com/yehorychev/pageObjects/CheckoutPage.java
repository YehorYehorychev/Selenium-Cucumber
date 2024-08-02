package com.yehorychev.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    public WebDriver driver;
    private WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "img[alt='Cart']")
    private WebElement cartBag;

    @FindBy(xpath = "//button[contains(text(),'PROCEED TO CHECKOUT')]")
    private WebElement checkoutButton;

    @FindBy(css = ".promoBtn")
    private WebElement promoButton;

    @FindBy(xpath = "//button[contains(text(),'Place Order')]")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//p[contains(text(),'Tomato')]")
    private WebElement productName;

    public void checkoutItems() {
        wait.until(ExpectedConditions.elementToBeClickable(cartBag)).click();
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }

    public Boolean verifyPromoButton() {
        return wait.until(ExpectedConditions.visibilityOf(promoButton)).isDisplayed();
    }

    public Boolean verifyPlaceOrder() {
        return wait.until(ExpectedConditions.visibilityOf(placeOrderButton)).isDisplayed();
    }

    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOf(productName)).getText().split("-")[0].trim();
    }
}