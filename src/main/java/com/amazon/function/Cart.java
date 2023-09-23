package com.amazon.function;

import com.amazon.page.CartPage;

public class Cart {

    private static final CartPage cart = new CartPage();

    public static boolean isAddedToCartMessageDisplaying(){
        return cart.isAddedToCartMessageDisplaying();
    }
}
