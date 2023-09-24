package com.amazon.function;

import com.amazon.util.BackgroundWorker;

public class Utility {

    private static final BackgroundWorker worker = new BackgroundWorker();

    public static void setPrice(String currency, double price, int quantity){
        worker.setPrice(currency,price,quantity);
    }
    public static String getPrice(){
        return worker.getPrice();
    }
}
