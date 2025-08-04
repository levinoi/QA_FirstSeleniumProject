package com.phonebook.tests;

import com.phonebook.core.TestBase;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.phonebook.core.ApplicationManager.softAssert;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition (){
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }


    @Test
    public void loginPositiveTest(){

        app.getUser().clickOnLoginLink();
        // enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("enigma2025@mail.com")
                .setPassword("Qay123$ddd"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }


    @Test
    public void loginNegativeWithoutEmailTest(){

        app.getUser().clickOnLoginLink();
        // enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setPassword("Qay123$ddd"));
        app.getUser().clickOnLoginButton();
        softAssert.assertTrue(app.getUser().isAlertPresent());
        softAssert.assertTrue(app.getUser().isErrorMessagePresent());
    }

}
