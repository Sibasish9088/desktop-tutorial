package org.example;

import static org.example.PalindromeCheckHelper.palindromeCheck;
import static org.example.LongestSequenceOfCharacters.findLongestSequenceOfCharacters;
import static org.example.IntegerPalindromeChecker.isPalindrome;
import static org.example.VowelPresenceChecker.hasVowel;
import static org.example.PrimeNumberChecker.isAPrimeNumber;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class SauceLabsExample {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
//        System.out.print("Please enter the word: ");
//        String enteredWord = sc.nextLine();
        System.out.print("Please enter the number: ");
        long enteredNumber = sc.nextLong();

//        System.out.println("You have entered: " + enteredWord);
        System.out.println("You have entered: " + enteredNumber);
//        if(palindromeCheck(enteredWord) == true) {
//            System.out.println(enteredWord + " is a Palindrome");
//        }
//        else {
//            System.out.println(enteredWord + " is not a Palindrome");
//        }
//        if(isPalindrome(enteredNumber) == true) {
//            System.out.println(enteredNumber + " is a Palindrome");
//        }
//        else {
//            System.out.println(enteredNumber + " is not a Palindrome");
//        }

//        String longestSequence = findLongestSequenceOfCharacters(enteredWord);
//        System.out.println("The longest sequence of characters in the given word is: " + longestSequence);
//        if (hasVowel(enteredWord)) System.out.println(enteredWord + " contains a vowel");
//        else System.out.println(enteredWord + " does not contain a vowel");

        if (isAPrimeNumber(enteredNumber)) System.out.println(enteredNumber + " is a Prime Number");
        else System.out.println(enteredNumber + " is not a Prime Number");

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//
//        Wait<WebDriver> wait = new FluentWait<WebDriver> (driver)
//                .withTimeout(5, TimeUnit.SECONDS)
//                        .pollingEvery(2, TimeUnit.SECONDS)
//                                .ignoring(NoSuchElementException.class);
//
//        driver.manage().window().maximize();
//        driver.get("https://www.saucedemo.com/");
//        Thread.sleep(2000);
//
//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//        Thread.sleep(2000);
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//        Thread.sleep(2000);
//        driver.findElement(By.id("login-button")).click();
//        WebElement swagLabsLogo = wait.until(new Function<WebDriver, WebElement>() {
//            @Override
//            public WebElement apply(WebDriver webDriver) {
//                return driver.findElement(By.cssSelector("div.app_logo"));
//            }
//        });
//
//        WebElement sauceLabsBikeLight = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
//        sauceLabsBikeLight.click();
//        Thread.sleep(2000);
//        driver.navigate().back();
//        Thread.sleep(2000);
//        try{
//            sauceLabsBikeLight.click();
//        } catch (StaleElementReferenceException staleElementReferenceException) {
//            System.err.println(staleElementReferenceException.getMessage());
//            driver.navigate().refresh();
//            sauceLabsBikeLight = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
//            sauceLabsBikeLight.click();
//            Thread.sleep(2000);
//        }
//        driver.quit();
    }
}
