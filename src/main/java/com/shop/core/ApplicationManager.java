package com.shop.core;

import com.shop.fw.ItemHelper;
import com.shop.fw.UserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class ApplicationManager  {

    private String browser;
    WebDriver driver;
    UserHelper userHelper;
    BaseHelper baseHelper;
    ItemHelper itemHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

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
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }

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
