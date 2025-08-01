package com.ait.qa63;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public String newEmail() {
        int i = (int) (System.currentTimeMillis() / 1000 % 3600);
        String email = "Enigma" + i + "@gmail.com";
        return email;
    }


    public void clickOnRegistrationLink() {
        driver.findElement(By.cssSelector("[href='/register']")).click();
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    //
    public void fillInRequiredFieldsToLogin(UserData user) {
        // enter email
        type(By.cssSelector("#Email"), user.getEmail());
        // enter password
        type(By.cssSelector("#Password"), user.getPassword());
    }

    public void fillInRequiredFields(UserData user) {

        type(By.cssSelector("#FirstName"), user.getUserName());
        type(By.cssSelector("#LastName"), user.getUserLastName());
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
        type(By.cssSelector("#ConfirmPassword"), user.getPassword());
        click(By.cssSelector("#register-button"));

        WebElement emailValue = driver.findElement(By.xpath("//a[@href='/customer/info']"));
        String userEmail = emailValue.getText();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public String getItemTitle() {
        WebElement item = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']//div[@class='item-box'][2]//h2[@class='product-title']/a"));
        String itemName = item.getText();
        System.out.println("item.getText() = " + item.getText());
        return itemName;
    }

    public void clickOnItemLink() {
        click(By.xpath(("//div[@class='product-grid home-page-product-grid']//div[@class='item-box'][2]//input[@value='Add to cart']")));

    }

    public void clickOnShoppingCart() {
        click(By.cssSelector("[href='/cart']"));
    }

    public void clickOnLoginButton() {
        click(By.cssSelector(".button-1.login-button"));
    }

    public boolean isItemAddedIntoCart(String text) {
        List<WebElement> items = driver.findElements(By.cssSelector("[href='/141-inch-laptop']"));
        for (WebElement element : items) {
            if (element.getText().equals(text)) return true;
        }
        return false;
    }
}
