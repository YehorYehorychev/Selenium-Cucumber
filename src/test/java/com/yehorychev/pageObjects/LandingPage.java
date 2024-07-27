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

    public void searchItem(String shortName) {
        driver.findElement(search).sendKeys(shortName);
    }

    public void getSearchItem() {
        driver.findElement(search).getText();
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public void selectTopDealsPage() {
        driver.findElement(topDeals).click();
    }
}
