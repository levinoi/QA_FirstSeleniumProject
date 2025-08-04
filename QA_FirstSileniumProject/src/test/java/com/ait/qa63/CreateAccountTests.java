package com.ait.qa63;

import com.shop.models.UserData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test (enabled = true)
    public void registrationCheck() {
        app.getUserHelper().clickOnRegistrationLink();
        app.getUserHelper().fillInRequiredFields(new UserData()
                .setUserName("Alya")
                .setUserLastName("L")
                .setPassword("Qay123$ddd")
                .setEmail(app.getBaseHelper().newEmail()));


        Assert.assertTrue(app.getBaseHelper().isElementPresent(By.xpath("//div[@class='page registration-result-page']//div[@class='result']")));
        Assert.assertTrue(app.getBaseHelper().isElementPresent(By.xpath("//a[@href='/customer/info']")));


    }

}
