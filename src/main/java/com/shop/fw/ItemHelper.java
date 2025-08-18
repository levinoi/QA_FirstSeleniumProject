package com.shop.fw;

import com.shop.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;

import java.util.List;

public class ItemHelper extends BaseHelper {


    public ItemHelper(WebDriver driver) {
        super(driver);
    }


    public String getItemTitle() {
        WebElement item = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']//div[@class='item-box'][2]//h2[@class='product-title']/a"));
        String itemName = item.getText();
        System.out.println("item.getText() = " + item.getText());
        return itemName;
    }

    public void clickOnItemLink(String number) {

         click(By.cssSelector(".item-box:nth-child("+number+") .add-info .buttons input")); //.item-box:nth-child(3) .add-info .buttons input
    }
    //   click(By.xpath(("//div[@class='product-grid home-page-product-grid']//div[@class='item-box'][2]//input[@value='Add to cart']")));
    public void clickOnShoppingCart() {
        click(By.cssSelector("[href='/cart']"));
    }

    public boolean isItemAddedIntoCart(String text) {
        // List<WebElement> items = driver.findElements(By.cssSelector("[href='/141-inch-laptop']"));
         List<WebElement> items = driver.findElements(By.cssSelector(".product-name"));
        for (WebElement element : items) {
            if (element.getText().equals(text)) return true;
        }
        return false;
    }
}
