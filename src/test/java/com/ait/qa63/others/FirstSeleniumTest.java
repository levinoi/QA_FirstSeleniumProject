package com.ait.qa63.others;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class FirstSeleniumTest {
    // initialize driver first of all
    WebDriver driver;

    @BeforeSuite // запускается перед всеми классами и другими аннотациями. Это точка входа при запуске тестов с одного пакеджа
    public void beforeSuite(){
        System.out.println("BeforeSuite method ");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite method ");
    }


    @BeforeTest
    public void beforeTest(){
        System.out.println("*********BeforeTest method ");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("***********AfterTest method ");
    }

    @BeforeClass // выполнится перед первым тестовым методом в текущем классе
    public void beforeClass(){
        System.out.println("***************BeforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("************** AfterClass");
    }





    // before - setUp
    @BeforeMethod // отрабатывает перед каждым методом pre conditions
    public void setUp() {
        System.out.println("***************BeforeMethod");
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
        System.out.println("**********************Test");
        System.out.println("google is opened");
    }


    // after - tearDown
    @AfterMethod(enabled = true)
    public void tearDown() {
        System.out.println("**********************AfterMethod");
        driver.quit();  // is closing entire browser
        // driver.close(); // is closing only one tab
    }
}
