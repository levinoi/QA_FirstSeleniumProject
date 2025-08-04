package com.ait.qa63.others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomeTask2 {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void findElementsByXPath(){

        driver.findElement(By.xpath("//h2"));
        driver.findElement(By.xpath("//p"));
       // System.out.println("tag1.getText() = " + tag1.getText());

        driver.findElement(By.xpath("//*[@class='topic-html-content-header']")); // "//*[@class='topic-html-content-header']"
        driver.findElement(By.xpath("//*[@class='poll-display-text']"));

        driver.findElement(By.xpath("//*[@id='dialog-notifications-success']"));
        driver.findElement(By.xpath("//*[@id='bar-notification']"));

        driver.findElement(By.xpath("//a[@href='/register']")); // "//a[@href='/search']"
        driver.findElement(By.xpath("//a[@href='/login']"));

        driver.findElements(By.xpath("//a[contains(text(), 'Shoes')]"));  //span[contains(text(),'Latest ')]
        List<WebElement> href= driver.findElements(By.xpath("//a[starts-with(@href,'/appar')]")); // "//a[starts-with(@href,'/ter')]"


    }

    @AfterMethod(enabled = true)
    public void quitPage() {
        driver.quit();
    }

}
