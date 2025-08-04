package com.shop.core;

import com.shop.fw.ItemHelper;
import com.shop.fw.UserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager  {

    WebDriver driver;
    UserHelper userHelper;
    BaseHelper baseHelper;
    ItemHelper itemHelper;

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public BaseHelper getBaseHelper() {
        return baseHelper;
    }

    public ItemHelper getItemHelper() {
        return itemHelper;
    }

    public void init() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        userHelper = new UserHelper(driver);
        baseHelper = new BaseHelper(driver);
        itemHelper = new ItemHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

}
