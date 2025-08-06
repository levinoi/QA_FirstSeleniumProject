package com.ait.qa63;
import com.shop.models.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        app.getUserHelper().clickOnLoginLink();
        app.getUserHelper().fillInRequiredFieldsToLogin(new UserData()
                .setEmail("lev_test@mail.com")
                .setPassword("Qay123$ddd")
        );
       app.getUserHelper().clickOnLoginButton();
    }

    @Test
    public void addItemToCartTest() {
        // pause(1000);
        String itemTitle = app.getItemHelper().getItemTitle();
        app.getItemHelper().clickOnItemLink("3");
        app.getBaseHelper().pause(2000);
        app.getItemHelper().clickOnShoppingCart();

        Assert.assertTrue(app.getItemHelper().isItemAddedIntoCart(itemTitle));
    }


}
