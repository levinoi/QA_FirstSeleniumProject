package com.ait.qa63;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementsTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");
        // maximize browser to window
        driver.manage().window().maximize();
        //  driver.manage().window().setSize(new Dimension(450,450));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByTagName() {
        //driver.findElement(By.tagName("h1"));
        WebElement title = driver.findElement(By.tagName("h1"));
        System.out.println(title.getText());
        WebElement element = driver.findElement(By.tagName("h2"));
        System.out.println(element.getText());

        WebElement link = driver.findElement(By.tagName("a"));
        System.out.println(link.getText());

        WebElement label = driver.findElement(By.tagName("label"));
        System.out.println(label.getText());

        List<WebElement> labels = driver.findElements(By.tagName("label"));
        System.out.println(labels.size());

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
    }

    @Test
    public void findElementById() {
        WebElement element = driver.findElement(By.id("city"));
        System.out.println(element.isDisplayed());
        List<WebElement> ids = driver.findElements(By.id("city"));
        System.out.println(ids.size());
        driver.findElement(By.id("dates"));
    }

    @Test
    public void findElementByClassName() {
        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println("telephone = " + telephone.getText());
        WebElement navLink = driver.findElement(By.className("navigation-link"));
        System.out.println("navLink = " + navLink.getDomAttribute("class"));
    }

    @Test
    public void findByLinktext() {
        WebElement linkText = driver.findElement(By.linkText("Let the car work"));
        System.out.println(linkText.getText());

        WebElement element = driver.findElement(By.linkText("Los Angeles"));
        System.out.println("element = " + element.getText());

    }
    @Test
    public void findByPartialLinkText(){
        WebElement element1 = driver.findElement(By.partialLinkText("Los"));
        System.out.println("element = " + element1.getText());
    }


    @AfterMethod
    public void quit() {
       // driver.quit();
    }

}
