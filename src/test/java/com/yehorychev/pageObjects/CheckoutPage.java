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


    public void checkoutItems() {
        driver.findElement(cartBag).click();
        driver.findElement(checkoutButton).click();
    }

    public void verifyPromoButton() {
        driver.findElement(promoButton).isDisplayed();
    }

    public void verifyPlaceOrder() {
        driver.findElement(placeOrderButton).isDisplayed();
    }
}
