package com.amazon.function;

import com.amazon.page.ProductPage;

public class Product {

    private static final ProductPage product = new ProductPage();

    public static String getUnitPrice(){
        return product.getUnitPrice();
    }
    public static String getProductTitle(){
        product.setUnitPrice();
        return product.getProductTitle();
    }
    public static void selectProductQuantity(int quantity){
        product.setUnitPrice();
        product.clickOnQuantityDropDown();
        product.selectQuantity(quantity);
    }
    public static void addToCart(){
        product.clickOnAddToCartButton();
    }

}
