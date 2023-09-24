package com.amazon.function;

import com.amazon.page.CartPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cart {

    private static final CartPage cart = new CartPage();

    public static boolean isAddedToCartMessageDisplaying(){
        return cart.isAddedToCartMessageDisplaying();
    }
    public static void clickOnGoToCartButton(){
        cart.clickOnGoToCartButton();
    }
    public static String getProductName(){
        return cart.getProductName();
    }
    public static String getQuantity(){
       return cart.getQuantity();
    }
    public static String getSubTotal(){
        return cart.getSubTotal();
    }


    public static void deleteProduct(){
        cart.clickOnDeleteButton();
    }

    /*
    *********
    * Click on go  to cart
    * Verify item name, quantity, and total price
    * clear the cart and verify it's 0
     */
}
