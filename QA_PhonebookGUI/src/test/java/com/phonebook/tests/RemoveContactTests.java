package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        clickOnLoginLink();
        // enter email
        fillLoginRegisterForm(new User()
                .setEmail("enigma2025@mail.com")
                .setPassword("Qay123$ddd"));

        // click on LOGIN button
        clickOnLoginButton();
        clickOnAddLink();
        fillContactForm("Bob", "Smith", "12625634342", "bob_smith@mai.com", "Berlin", "Goalkeeper");
        clickOnSaveButton();
    }
    @Test
    public void removeContactTest(){
        // assert by size
        int sizeBefore = sizeOfContacts();
        removeContact();
        pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }
}
