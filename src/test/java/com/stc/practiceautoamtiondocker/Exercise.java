
package com.stc.practiceautoamtiondocker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        ChromeOptions options = new ChromeOptions();

        // For Docker
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);

        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void loginTest() {

        // Enter username
        WebElement user = driver.findElement(By.id("username"));
        user.sendKeys("student");

        // Enter password
        WebElement psw = driver.findElement(By.id("password"));
        psw.sendKeys("Password123");

        // Click submit
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        // Click logout
        WebElement logout = driver.findElement(
                By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div/div/div/a"));

        logout.click();
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
