package com.ait.qa63;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    String emailToUse;
    String userEmail;

    @Test
    public void registrationCheck() {
        driver.findElement(By.cssSelector("[href='/register']")).click();
        // fill in required fields
        fillInRequiredFields();
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='page registration-result-page']//div[@class='result']")));
        Assert.assertTrue(isElementPresent(By.xpath("//a[@href='/customer/info']")));

        //   Assert.assertEquals(emailToUse,userEmail);
        //   System.out.println("emailToUse = " + emailToUse);
        //   System.out.println("userEmail = " + userEmail);

    }

    public void fillInRequiredFields() {
        driver.findElement(By.cssSelector("#FirstName")).click();
        driver.findElement(By.cssSelector("#FirstName")).clear();
        driver.findElement(By.cssSelector("#FirstName")).sendKeys("Lady");
        driver.findElement(By.cssSelector("#LastName")).sendKeys("JLo");

        driver.findElement(By.cssSelector("#Email")).sendKeys(newEmail());
        driver.findElement(By.cssSelector("#Password")).sendKeys("Qay1234$fvfv");
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("Qay1234$fvfv");
        driver.findElement(By.cssSelector("#register-button")).click();
        WebElement emailValue = driver.findElement(By.xpath("//a[@href='/customer/info']"));
        String userEmail = emailValue.getText();
    }
}
