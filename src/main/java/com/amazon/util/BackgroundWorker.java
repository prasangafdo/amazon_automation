package com.amazon.util;

public class BackgroundWorker {

    private String price;

    public void setPrice(String currency, double price, int quantity){
        this.price = currency+ price*quantity;
    }
    public String getPrice(){
        return price;
    }
}
