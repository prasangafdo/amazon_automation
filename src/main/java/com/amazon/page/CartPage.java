package com.amazon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends LandingPage{

    private final By lblAddedToCart = By.xpath("//div[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']");

    private final String txtAddedToCartMessage = "Added to Cart";

    public boolean isAddedToCartMessageDisplaying(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       return wait.until(ExpectedConditions.visibilityOfElementLocated(lblAddedToCart)).getText().contains(txtAddedToCartMessage);
       //Using contains keyword instead of equals or equalsIgnoreCase to overcome the issues related to empty spaces when capturing text content from a web element
    }


}
