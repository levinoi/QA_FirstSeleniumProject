package com.shop.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
