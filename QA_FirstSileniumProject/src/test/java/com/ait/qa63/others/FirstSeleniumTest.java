package com.ait.qa63.others;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    // initialize driver first of all
    WebDriver driver;

    // before - setUp
    @BeforeMethod // pre conditions
    public void setUp() {
        driver = new ChromeDriver();
        // selenium webdriver finds this webdriver on my computer, in path parametr
        // driver.get("https://www.google.com/");
        driver.navigate().to("https://www.google.com/"); // with history
        driver.navigate().back(); // is using back arrow in browser, goes to previous page
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    // test
    @Test
    public void firstTest() {
        System.out.println("google is opened");
    }


    // after - tearDown
    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();  // is closing entire browser
        // driver.close(); // is closing only one tab
    }
}
