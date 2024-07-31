package com.yehorychev.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    public WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By cartBag = By.cssSelector("img[alt='Cart']");
    private By checkoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    private By promoButton = By.cssSelector(".promoBtn");
    private By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");
    private By productName = By.xpath("//p[contains(text(),'Tomato')]");


    public void checkoutItems() {
        driver.findElement(cartBag).click();
        driver.findElement(checkoutButton).click();
    }

    public Boolean verifyPromoButton() {
        return driver.findElement(promoButton).isDisplayed();
    }

    public Boolean verifyPlaceOrder() {
        return driver.findElement(placeOrderButton).isDisplayed();
    }

    public String getProductName() {
        return driver.findElement(productName).getText().split("-")[0].trim();
    }
}
