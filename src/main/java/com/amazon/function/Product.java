package com.amazon.function;

import com.amazon.page.ProductPage;

public class Product {

    private static final ProductPage product = new ProductPage();

    public static String getUnitPrice(){
        return product.getUnitPrice();
    }
    public static String getProductTitle(){
        return product.getProductTitle();
    }
    public static void selectProductQuantity(int quantity){
        product.clickOnQuantityDropDown();
        product.selectQuantity(quantity);
    }

}