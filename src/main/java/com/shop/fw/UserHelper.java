package com.shop.fw;

import com.shop.core.BaseHelper;
import com.shop.models.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnRegistrationLink() {
        driver.findElement(By.cssSelector("[href='/register']")).click();
    }

    public void clickOnSignOutButton(){
        driver.findElement(By.cssSelector("[href='/logout']")).click();
    }

    //
    public void fillInRequiredFieldsToLogin(UserData user) {
        // enter email
        type(By.cssSelector("#Email"), user.getEmail());
        // enter password
        type(By.cssSelector("#Password"), user.getPassword());
    }

    public void fillInRequiredFields(UserData user) {

        type(By.cssSelector("#FirstName"), user.getUserName());
        type(By.cssSelector("#LastName"), user.getUserLastName());
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
        type(By.cssSelector("#ConfirmPassword"), user.getPassword());
        click(By.cssSelector("#register-button"));

    }

    public void clickOnLoginButton() {
        click(By.cssSelector(".button-1.login-button"));
    }
}
