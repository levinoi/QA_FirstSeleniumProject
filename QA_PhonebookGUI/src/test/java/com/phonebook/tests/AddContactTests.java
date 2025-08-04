package com.phonebook.tests;

import com.phonebook.core.TestBase;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        // enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("enigma2025@mail.com")
                .setPassword("Qay123$ddd"));
        // click on LOGIN button
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName("Bob")
                .setLastName("Smith")
                .setPhone("12625634342")
                .setEmail("bob_smith@mai.com")
                .setAddress("Berlin")
                .setDescription("Goalkeeper"));
        app.getContact().clickOnSaveButton();

        //assert new Contact by string
        Assert.assertTrue(app.getContact().isContactCreated("Bob"));

    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();

    }

}