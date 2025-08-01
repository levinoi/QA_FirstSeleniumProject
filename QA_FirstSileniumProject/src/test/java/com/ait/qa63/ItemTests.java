package com.ait.qa63;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        clickOnLoginLink();
        fillInRequiredFieldsToLogin(new UserData()
                .setEmail("lev_test@mail.com")
                .setPassword("Qay123$ddd")
        );
        clickOnLoginButton();
    }

    @Test
    public void addItemToCartTest() {
       // pause(1000);
        String itemTitle = getItemTitle();
        clickOnItemLink();
        pause(2000);
        clickOnShoppingCart();

        Assert.assertTrue(isItemAddedIntoCart(itemTitle));
    }


}
