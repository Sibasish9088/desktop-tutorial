package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class SauceLabsExample {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        Wait<WebDriver> wait = new FluentWait<WebDriver> (driver)
                .withTimeout(5, TimeUnit.SECONDS)
                        .pollingEvery(2, TimeUnit.SECONDS)
                                .ignoring(NoSuchElementException.class);

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.id("login-button")).click();
        WebElement swagLabsLogo = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.cssSelector("div.app_logo"));
            }
        });

        WebElement sauceLabsBikeLight = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
        sauceLabsBikeLight.click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        try{
            sauceLabsBikeLight.click();
        } catch (StaleElementReferenceException staleElementReferenceException) {
            System.err.println(staleElementReferenceException.getMessage());
            driver.navigate().refresh();
            sauceLabsBikeLight = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
            sauceLabsBikeLight.click();
            Thread.sleep(2000);
        }
        driver.quit();
    }
}
