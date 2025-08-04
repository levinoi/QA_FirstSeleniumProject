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

public class TableTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void tableCssSelectorTest() {
        // get numbers of rows
        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
        System.out.println("rows.size() = " + rows.size());
        System.out.println("***********************************");
        for (int i = 0; i < rows.size(); i++) {
            System.out.println(rows.get(i).getText());
        }

        System.out.println("***********************************");
        // get row
        WebElement austria = driver.findElement(By.cssSelector("tr:nth-child(5)"));
        System.out.println("austria.getText() = " + austria.getText());

        WebElement peter = driver.findElement(By.cssSelector(" .fullwidthtable tr:nth-child(2)"));
        System.out.println("peter.getText() = " + peter.getText());

        // get row 5, last element
        WebElement austriaValue = driver.findElement(By.cssSelector("tr:nth-child(5) td:nth-child(3)"));
        System.out.println("austriaValue.getText() = " + austriaValue.getText());

        // XPath

    }

    @Test
    public void findByXpath(){
//        driver.findElement(By.xpath("//input[@id='city']"));
//        driver.findElement(By.xpath("//input[@id='dates']"));
    }

    @Test
    public void xpathTableTest() {
        //get row 5
        WebElement austria = driver.findElement(By.xpath("//tr[5]"));
        System.out.println(austria.getText());
        System.out.println("**********************************************");

        WebElement peter =  driver.findElement(By.xpath("//*[@class='fullwidthtable']//tr[2]"));
        System.out.println("peter.getText() = " + peter.getText());

        WebElement austriaValue = driver.findElement(By.xpath("//tr[5]//td[last()]"));
        System.out.println("austriaValue.getText() = " + austriaValue.getText());

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
