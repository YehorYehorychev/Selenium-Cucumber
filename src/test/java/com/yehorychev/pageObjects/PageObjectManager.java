package com.yehorychev.pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public WebDriver driver;
    public LandingPage landingPage;
    public OffersPage offersPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage getLandingPage() {
        landingPage = new LandingPage(driver);
        return landingPage;
    }

    public OffersPage getOffersPage() {
        offersPage = new OffersPage(driver);
        return offersPage;
    }
}
