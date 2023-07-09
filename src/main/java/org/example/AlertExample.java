package org.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/delete_customer.php");
        Thread.sleep(2000);

        String mainWindowTitle = driver.getTitle();
        String mainWindow = driver.getWindowHandle();

        driver.findElement(By.name("cusid")).sendKeys("2345");
        Thread.sleep(2000);
        driver.findElement(By.name("submit")).click();
        Thread.sleep(2000);

        Alert deleteCustomerAlert = driver.switchTo().alert();
        Thread.sleep(2000);

        System.out.println("Alert: " + deleteCustomerAlert.getText());
        deleteCustomerAlert.accept();
        Thread.sleep(2000);

        driver.switchTo().alert().accept();
        assertThat(driver.getTitle(), equalTo(mainWindowTitle));

        driver.close();
    }
}