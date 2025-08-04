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

public class homeTask1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void findElementsByTagName() {
        WebElement title = driver.findElement(By.tagName("h2"));
        System.out.println("h2 value = " + title.getText());

        List<WebElement> span = driver.findElements(By.tagName("span"));
        span.forEach(sp -> System.out.println(sp.getText()));

        WebElement parag = driver.findElement(By.tagName("p"));
        System.out.println("paragraf value = " + parag.getText());

    }

    @Test
    public void findElementsByClassName() {
        WebElement class1 = driver.findElement(By.className("topic-html-content-header"));
        System.out.println("class1 = " + class1.getText());

        WebElement class2 = driver.findElement(By.className("poll-display-text"));
        System.out.println("class2 = " + class2.getText());

    }

    @Test
    public void findElementById() {
        WebElement elementId1 = driver.findElement(By.id("dialog-notifications-success"));
        System.out.println("elementId1.isDisplayed() = " + elementId1.isEnabled());

        WebElement elementId2 = driver.findElement(By.id("bar-notification"));
        System.out.println("elementId2.isDisplayed() = " + elementId2.isEnabled());

    }

    @Test
    public void findByLinktext() {
        WebElement linkText1 = driver.findElement(By.linkText("Register"));
        System.out.println("linkText1 = " + linkText1.getText());

        WebElement linkText2 = driver.findElement(By.linkText("Log in"));
        System.out.println("linkText2 = " + linkText2.getText());

    }

    @Test
    public void findByPartialLinkText() {
        WebElement partialLink2 = driver.findElement(By.partialLinkText("log"));
        System.out.println("partialLink2 = " + partialLink2.getText());

        WebElement partialLink1 = driver.findElement(By.partialLinkText("Apparel"));
        System.out.println("partialLink1 = " + partialLink1.getText());
    }

    @Test
    public void findElementsByCssSelector(){
        driver.findElement(By.cssSelector("h2"));
        driver.findElement(By.cssSelector("p"));

        driver.findElement(By.cssSelector(".topic-html-content-header"));
        driver.findElement(By.cssSelector(".poll-display-text"));

        driver.findElement(By.cssSelector("#dialog-notifications-success"));
        driver.findElement(By.cssSelector("#bar-notification"));

        driver.findElement(By.cssSelector("[href='/register']"));
        driver.findElement(By.cssSelector("[href='/login']"));

        List<WebElement> links1 = driver.findElements(By.cssSelector("[href$='-shoes']"));
        System.out.println("links.size() = " + links1.size());

        List<WebElement> links2 = driver.findElements(By.cssSelector("[href^='/appar']"));
        System.out.println("links2.size() = " + links2.size());

        List<WebElement> links3 = driver.findElements(By.cssSelector("[href*='electro']"));
        System.out.println("links3.size() = " + links3.size());


    }

    @AfterMethod(enabled = true)
    public void quitPage() {
        driver.quit();
    }
}
