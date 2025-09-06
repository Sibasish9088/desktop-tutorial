package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public enum ThreadSafeWebDriverManager {
    INSTANCE;

    private final String defaultBrowser = System.getProperty("browser", "chrome").toLowerCase();
    private final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private final ThreadLocal<String> tlBrowser = ThreadLocal.withInitial(() -> defaultBrowser);

    // Set browser per thread (optional)
    public void setBrowserForCurrentThread(String browserName) {
        if (browserName != null && !browserName.isBlank()) {
            tlBrowser.set(browserName.toLowerCase());
        }
    }

    // Get WebDriver instance for current thread
    public WebDriver getDriver() {
        WebDriver driver = tlDriver.get();
        if (driver == null) {
            String browser = tlBrowser.get();
            driver = switch (browser) {
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    yield new FirefoxDriver();
                }
                case "edge" -> {
                    WebDriverManager.edgedriver().setup();
                    yield new EdgeDriver();
                }
                default -> {
                    WebDriverManager.chromedriver().setup();
                    yield new ChromeDriver();
                }
            };
            tlDriver.set(driver);
        }
        return driver;
    }

    // Quit and clean up driver for current thread
    public void quitDriverForCurrentThread() {
        WebDriver driver = tlDriver.get();
        if (driver != null) {
            driver.quit();
            tlDriver.remove();
            tlBrowser.remove();
        }
    }
}
