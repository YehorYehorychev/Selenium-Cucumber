package com.yehorychev.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    By search = By.xpath("//input[@type='search']");
    By productName = By.xpath("//h4[normalize-space()='Tomato - 1 Kg']");

    public void searchItem(String shortName) {
        driver.findElement(search).sendKeys(shortName);
    }
}
