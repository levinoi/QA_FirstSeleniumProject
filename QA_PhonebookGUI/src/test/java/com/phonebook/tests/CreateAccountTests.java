package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void newUserRegistrationPositiveTest(){
        // click on LOGIN link
        driver.findElement(By.cssSelector("[href='/login']")).click();
        // enter email
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("Enigma2025@mail.com");
        // enter password
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("Qay123$ddd");

        // click on Registration button
        driver.findElement(By.name("registration")).click();
        // assert Sign Out button
        Assert.assertTrue(isElementPresent(By.cssSelector("button")));

    }


}
