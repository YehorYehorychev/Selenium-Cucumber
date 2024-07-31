package com.yehorychev.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    private By search = By.xpath("//input[@type='search']");
    private By productName = By.xpath("//h4[normalize-space()='Tomato - 1 Kg']");
    private By topDeals = By.xpath("//a[normalize-space()='Top Deals']");
    private By addToCart = By.cssSelector(".product-action button");
    private By increment = By.cssSelector("a.increment");

    public void searchItem(String shortName) {
        driver.findElement(search).sendKeys(shortName);
    }

    public void getSearchItem() {
        driver.findElement(search).getText();
    }

    public void incrementQuantity(int quantity) {
        int i = quantity -1;
        while (i > 0) {
            driver.findElement(increment).click();
            i--;
        }
    }

    public void addToCart() {
        driver.findElement(addToCart).click();
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public void selectTopDealsPage() {
        driver.findElement(topDeals).click();
    }

    public String getTitleLandingPage() {
        return driver.getTitle();
    }
}
