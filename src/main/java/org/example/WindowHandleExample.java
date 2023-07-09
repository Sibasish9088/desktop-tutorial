package org.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandleExample {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/popup.php");
        Thread.sleep(2000);

        String mainWindowTitle = driver.getTitle();
        String mainWindow = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[contains(text(), 'Click Here')]")).click();
        Thread.sleep(2000);

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> windowIterator = windows.iterator();

        while(windowIterator.hasNext()) {
            String childWindow = windowIterator.next();

            if(!mainWindow.equalsIgnoreCase(childWindow)) {

                driver.switchTo().window(childWindow);
                Thread.sleep(2000);

                driver.findElement(By.name("emailid")).sendKeys("johndoe@example.com");
                Thread.sleep(2000);
                driver.findElement(By.name("btnLogin")).click();
                Thread.sleep(2000);

                driver.close();
            }
        }

        driver.switchTo().window(mainWindow);
        Thread.sleep(2000);
        assertThat(driver.getTitle(), equalTo(mainWindowTitle));

        driver.quit();
    }
}
