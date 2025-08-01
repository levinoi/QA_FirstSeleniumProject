package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void loginPositiveTest(){

        clickOnLoginLink();
        // enter email
        fillLoginRegisterForm(new User()
                .setEmail("enigma2025@mail.com")
                .setPassword("Qay123$ddd"));
        clickOnLoginButton();
        Assert.assertTrue(isSignOutButtonPresent());
    }


    @Test
    public void loginNegativeWithoutEmailTest(){

        clickOnLoginLink();
        // enter email
        fillLoginRegisterForm(new User()
                .setPassword("Qay123$ddd"));
        clickOnLoginButton();
        Assert.assertTrue(isAlertPresent());
    }

}
