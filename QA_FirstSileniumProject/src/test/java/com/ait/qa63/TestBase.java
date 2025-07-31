package com.ait.qa63;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }

    public String newEmail(){
        int i = (int) (System.currentTimeMillis()/1000%3600);
        String email = "Enigma" + i + "@gmail.com";
        return email;
    }


    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }
}
