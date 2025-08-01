package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        clickOnLoginLink();
        // enter email
        fillLoginRegisterForm(new User()
                .setEmail("enigma2025@mail.com")
                .setPassword("Qay123$ddd"));
        // click on LOGIN button
        clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        clickOnAddLink();
        fillContactForm("Bob", "Smith", "12625634342", "bob_smith@mai.com", "Berlin", "Goalkeeper");
        clickOnSaveButton();

        //assert new Contact by string
        Assert.assertTrue(isContactCreated("Bob"));

    }

    @AfterMethod
    public void postCondition() {
        removeContact();

    }

}