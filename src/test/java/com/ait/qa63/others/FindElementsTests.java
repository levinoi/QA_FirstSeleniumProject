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

    @Test (enabled = false)
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
    public void findByPartialLinkText() {
        WebElement element1 = driver.findElement(By.partialLinkText("Los"));
        System.out.println("element = " + element1.getText());
    }

    @Test
    public void findElementsByCssSelector() {
        // driver.findElement(By.tagName("h1"));
        // tagName -> h1
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("h2"));

        // id= 'city' -> #city
        driver.findElement(By.cssSelector("#city"));
        driver.findElement(By.cssSelector("#dates"));

        // classname 'telephone' -> .name_class
        driver.findElement(By.cssSelector(".telephone"));
        driver.findElement(By.cssSelector(".navigation-link"));

        // key - value
        driver.findElement(By.cssSelector("[href='/search']"));
        driver.findElement(By.cssSelector("[href='/let-car-work']"));

        // contains
        driver.findElement(By.cssSelector("[href*='/reg']"));
        driver.findElement(By.cssSelector("[class*='offers']"));

        // start -> ^ с чего начинается локатор
        driver.findElement(By.cssSelector("[href^='/ter']"));
        driver.findElement(By.cssSelector("[class^='red']"));

        // end to -> $
        driver.findElement(By.cssSelector("[href$='-work']"));
        driver.findElement(By.cssSelector("[class$='cities']"));

        // composite  cssSelector
        driver.findElement(By.cssSelector(".logo>img")); // one step above
        driver.findElement(By.cssSelector(".input-container [formcontrolname='city']")); // space two or more  steps

        // tag or class or <id>:nth-child(n)
        WebElement elem = driver.findElement(By.cssSelector(".navigation-link:nth-child(6)"));
        System.out.println("elem = " + elem.getText());


    }

    @Test
    public void findByXpath() {

        //XPath //tag[@attribute='parameter'] = //*[@attribute='parameter"]
        //tag[1]
        //tag[@attribute='parameter' or attribute2='parameter'2]
        // function() //tag[function()=text']

        // id -> //tag[@id='value']
        driver.findElement(By.xpath("//input[@id='city']"));
        driver.findElement(By.xpath("//input[@id='dates']"));

        // class -> //tag[@class='value']
        driver.findElement(By.xpath("//*[@class='telephone']"));
        driver.findElement(By.xpath("//a[@class='navigation-link']"));

        driver.findElement(By.xpath("//a[@href='/search']"));
        driver.findElement(By.xpath("//a[@href='/let-car-work']"));

        driver.findElement(By.xpath("//a[starts-with(@href,'/ter')]"));
        driver.findElement(By.xpath("//*[starts-with(@class,'red')]"));

        // contains text
        // partial text
        WebElement text = driver.findElement(By.xpath("//span[contains(text(),'Latest ')]"));
        WebElement text1 = driver.findElement(By.xpath("//span[contains(.,'Latest ')]"));

        System.out.println("text.getText() = " + text.getText());

        // equals text
        driver.findElement(By.xpath("//span[text()=' Latest feedback from our customers ']"));

//        driver.findElement(By.cssSelector(".logo>img")); // one step above
//        driver.findElement(By.cssSelector(".input-container [formcontrolname='city']"));

        driver.findElement(By.xpath("//*[@class='logo']/img"));
        driver.findElement(By.xpath("//*[@class='input-container']//*[@formcontrolname='city']"));

        // cssSelector -> div>a     xpath -> //div/a
        // cssSelector -> div a      xpath -> //div//a

        // parent
        WebElement parent = driver.findElement(By.xpath("//h1/parent::*"));
        WebElement parent1 = driver.findElement(By.xpath("//h1/parent::div"));
        WebElement parent3 = driver.findElement(By.xpath("//h1/.."));

        System.out.println("parent.getDomAttribute(\"class\") = " + parent.getDomAttribute("class"));

        // ancestor
        WebElement ancestor = driver.findElement(By.xpath("//h1/ancestor::div[2]"));
        WebElement ancestor1 = driver.findElement(By.xpath("//h1/../.."));

        System.out.println("ancestor.getDomAttribute(\"class\") = " + ancestor.getDomAttribute("class"));
        System.out.println("ancestor1.getDomAttribute(\"class\") = " + ancestor1.getDomAttribute("class"));

        // following-sibling - next "bottom" brother
        WebElement text2 = driver.findElement(By.xpath("//h1/following-sibling::h2"));
        System.out.println("text2.getText() = " + text2.getText());


    }


    @AfterMethod
    public void quit() {
       driver.quit();
    }

}
