package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Random;
import java.util.random.RandomGenerator;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://telranedu.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public boolean isHomeComponentPresent(){
        return isElementPresent(By.xpath("//div[2]//h1"));
                //driver.findElements(By.xpath("//div[2]//h1")).size()>0;
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
