package com.shop.core;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class BaseHelper {
protected WebDriver driver;

    public BaseHelper(WebDriver driver) {
      this.driver = driver;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public String newEmail() {
        int i = (int) (System.currentTimeMillis() / 1000 % 3600);
        String email = "Enigma" + i + "@gmail.com";
        return email;
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

    public String takeScreenShot(){
        // in selenium library exists special class
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File( "screenshots/screen - " + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return screenshot.getAbsolutePath();
    }
}
























