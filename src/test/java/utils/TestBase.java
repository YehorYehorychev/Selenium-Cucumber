package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
   /*
     This class sets up and manages the WebDriver instance and its configurations,
     including browser type, timeouts, and grid setup
   */
    public WebDriver driver;
    public WebDriverWait wait;

    public WebDriver webDriverManager() throws IOException {
        if (driver == null) {
            Properties properties = loadProperties();
            String browser = properties.getProperty("browser", "chrome");
            String qaUrl = properties.getProperty("QAUrl");
            String gridUrl = properties.getProperty("gridUrl");

            if (gridUrl == null || gridUrl.isEmpty()) {
                switch (browser.toLowerCase()) {
                    case "chrome" -> {
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                    }
                    case "firefox" -> {
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                    }
                    default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
                }
            } else {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                switch (browser.toLowerCase()) {
                    case "chrome" -> capabilities.setCapability(
                            ChromeOptions.CAPABILITY, new ChromeOptions());
                    case "firefox" -> capabilities.setCapability(
                            FirefoxOptions.FIREFOX_OPTIONS, new FirefoxOptions());
                    default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
                }
                driver = new RemoteWebDriver(new URL(gridUrl), capabilities);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds
                    (Long.parseLong(properties.getProperty("timeout"))));
            driver.get(qaUrl);
            wait = new WebDriverWait(driver, Duration.ofSeconds
                    (Long.parseLong(properties.getProperty("timeout"))));
        }
        return driver;
    }

    private Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream
                (System.getProperty("user.dir") + "/src/test/resources/global.properties")) {
            properties.load(fileInputStream);
        }
        return properties;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}

// If you need to run your test not inside the Docker Container use this code ->

/*  public WebDriver driver;
    public WebDriverWait wait;

    public WebDriver webDriverManager() throws IOException {
        if (driver == null) {
            Properties properties = loadProperties();
            String browser = properties.getProperty("browser", "chrome");
            String qaUrl = properties.getProperty("QAUrl");

            switch (browser.toLowerCase()) {
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                case "edge" -> {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
                case "safari" -> {
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                }
                default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds
                    (Long.parseLong(properties.getProperty("timeout"))));
            driver.get(qaUrl);
            wait = new WebDriverWait(driver, Duration.ofSeconds
                    (Long.parseLong(properties.getProperty("timeout"))));
        }
        return driver;
    }

    private Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")
                + "/src/test/resources/global.properties")) {
            properties.load(fileInputStream);
        }
        return properties;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
  */