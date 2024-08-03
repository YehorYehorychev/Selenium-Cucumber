package com.yehorychev.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GenericUtils;

import java.time.Duration;

public class CheckoutPage extends GenericUtils {
    public WebDriver driver;
    private WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        super(driver);
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
        waitForElementToBeClickable(cartBag).click();
        waitForElementToBeClickable(checkoutButton).click();
    }

    public Boolean verifyPromoButton() {
        return waitForElementToBeVisible(promoButton).isDisplayed();
    }

    public Boolean verifyPlaceOrder() {
        return waitForElementToBeVisible(placeOrderButton).isDisplayed();
    }

    public String getProductName() {
        return waitForElementToBeVisible(productName).getText().split("-")[0].trim();
    }
}