package com.ait.qa63;

import com.shop.models.UserData;
import com.shop.utils.MyDataProvider;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests extends TestBase {

    @Test(enabled = true)
    public void registrationTest() {
        app.getUserHelper().clickOnRegistrationLink();
        app.getUserHelper().fillInRequiredFields(new UserData()
                .setUserName("Alya")
                .setUserLastName("L")
                .setPassword("Qay123$ddd")
                .setEmail(app.getBaseHelper().newEmail()));


        Assert.assertTrue(app.getBaseHelper().isElementPresent(By.xpath("//div[@class='page registration-result-page']//div[@class='result']")));
        app.getUserHelper().clickOnSignOutButton();
    }


    @Test(dataProviderClass = MyDataProvider.class, dataProvider = "addNewUser",enabled = false)
    public void registrationTestWithDataProvider(String name, String lastname, String password, String email) {
        app.getUserHelper().clickOnRegistrationLink();
        app.getUserHelper().fillInRequiredFields(new UserData()
                .setUserName(name)
                .setUserLastName(lastname)
                .setPassword(password)
                .setEmail(email));

        Assert.assertTrue(app.getBaseHelper().isElementPresent(By.xpath("//div[@class='page registration-result-page']//div[@class='result']")));
        app.getUserHelper().clickOnSignOutButton();
    }


    @Test( dataProviderClass = MyDataProvider.class, dataProvider = "addNewUserFromCsv",enabled = false)
    public void registrationTestWithDataProviderWithCsvFile(UserData userData) {
        app.getUserHelper().clickOnRegistrationLink();
        app.getUserHelper().fillInRequiredFields(userData);

        Assert.assertTrue(app.getBaseHelper().isElementPresent(By.xpath("//div[@class='page registration-result-page']//div[@class='result']")));
        app.getUserHelper().clickOnSignOutButton();
    }



}
























