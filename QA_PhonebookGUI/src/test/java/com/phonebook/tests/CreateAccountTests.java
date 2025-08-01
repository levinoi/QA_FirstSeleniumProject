package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test (enabled = false)
    public void newUserRegistrationPositiveTest() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("enigma2025@mail.com")
                .setPassword("Qay123$ddd"));

        clickOnRegistrationButton();

        Assert.assertTrue(isSignOutButtonPresent());

    }

    @Test
    public void existedUserRegistrationNegativeTest() {
         clickOnLoginLink();
        // enter email
        fillLoginRegisterForm(new User()
                .setEmail("enigma2025@mail.com")
                .setPassword("Qay123$ddd"));

        // click on Registration button
        clickOnRegistrationButton();
        Assert.assertTrue(isAlertPresent());
    }

}
