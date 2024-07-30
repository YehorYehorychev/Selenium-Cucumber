package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;
    public WebDriverWait wait;

    public WebDriver webDriverManager() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") +
                "//src//test//resources//global.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String qaUrl = properties.getProperty("QAUrl");

        if (driver == null) {
            String browser = properties.getProperty("browser");
            switch (browser) {
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
                default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
            driver.get(qaUrl);
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        }
        return driver;
    }
    public WebDriverWait getWait() {
        return wait;
    }
}