package com.ait.qa63;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void registrationCheck() {
        clickOnRegistrationLink();
        fillInRequiredFields(new UserData()
                .setUserName("Alesik")
                .setUserLastName("Levi")
                .setPassword("Qay123$ddd")
                .setEmail("lev_test@mail.com"));


        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='page registration-result-page']//div[@class='result']")));
        Assert.assertTrue(isElementPresent(By.xpath("//a[@href='/customer/info']")));


    }

}
