package com.ait.qa63;

import com.shop.core.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;


public class TestBase  {
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod (alwaysRun = true)
    // добавляем Метод что бы его название отобразилось в лог файле
    public void startTest(Method method){
        logger.info("Start test - {} ", method.getName());
    }

    @BeforeSuite (alwaysRun = true)
    public void setUp() {
        app.init();

    }

    @AfterMethod
    public void stopTest(ITestResult result){
       if (result.isSuccess()) {
           logger.info("PASSED: {}", result.getMethod().getMethodName());
       } else {
           logger.info("FAILED: {} Screenshot: {}", result.getMethod().getMethodName(), app.getBaseHelper().takeScreenShot());
       }
       logger.info("Stop test");
       logger.info("****************");
    }

    @AfterSuite(enabled = true, alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

}

// .item-box:nth-child(3) .add-info .buttons input
