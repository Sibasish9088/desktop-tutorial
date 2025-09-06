package org.example;

import org.openqa.selenium.WebDriver;

public class DemoTest {
    public static void main(String[] args) {
        // Option 1: set per-thread browser
        ThreadSafeWebDriverManager.INSTANCE.setBrowserForCurrentThread("chrome");

        // Option 2: or use system property (default = chrome)
        // mvn test -Dbrowser=edge

        WebDriver driver = ThreadSafeWebDriverManager.INSTANCE.getDriver();
        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());

        ThreadSafeWebDriverManager.INSTANCE.quitDriverForCurrentThread();
    }
}

