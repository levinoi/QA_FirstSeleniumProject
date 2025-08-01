package com.phonebook.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://telranedu.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public boolean isHomeComponentPresent() {
        return isElementPresent(By.xpath("//div[2]//h1"));
        //driver.findElements(By.xpath("//div[2]//h1")).size()>0;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public String newEmail() {
        int i = (int) (System.currentTimeMillis() / 1000 % 3600);
        String email = "Enigma" + i + "@gmail.com";
        return email;
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        driver.quit();
    }

    public void type(By locator, String text) {
        if (text!=null) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            return true;
        }
    }

    public void clickOnRegistrationButton() {
        click(By.name("registration"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.cssSelector("button"));
    }

    public void fillLoginRegisterForm(User user) {
        // enter email
        type(By.name("email"), user.getEmail());
        // enter password
        type(By.name("password"), user.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnLoginButton() {
        click(By.name("login"));
    }

    public void clickOnSaveButton() {
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void fillContactForm(String name, String lastName, String phone, String email,
                                String address, String description) {
        //enter name
        type(By.xpath("//input[1]"), name);
//enter lastname
        type(By.xpath("//input[2]"), lastName);
//enter phone
        type(By.xpath("//input[3]"), phone);
//enter email
        type(By.xpath("//input[4]"), email);
//enter address
        type(By.xpath("//input[5]"), address);
//enter description
        type(By.xpath("//input[6]"), description);
    }

    public void clickOnAddLink() {
        click(By.cssSelector("[href='/add']"));
    }

    public boolean isContactCreated(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement element: contacts){
            if (element.getText().equals(text)) return true;
        }
        return false;
    }

    public void removeContact() {
        // click on card
        click(By.cssSelector(".contact-item_card__2SOIM"));
        // click on remove button
        click(By.xpath("//button[.='Remove']"));
    }

    public int sizeOfContacts(){
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))) {
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
            return 0;
    }
}
