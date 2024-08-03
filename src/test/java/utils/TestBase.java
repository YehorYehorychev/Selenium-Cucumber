package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;
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