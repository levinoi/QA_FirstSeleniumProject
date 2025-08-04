package com.ait.qa63;

import com.shop.core.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase  {
    ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() {
        app.init();

    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        app.stop();
    }

}

// .item-box:nth-child(3) .add-info .buttons input
