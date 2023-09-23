package com.amazon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends LandingPage{

    private final By lblAddedToCart = By.xpath("//div[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']");
    private final By btnGoToCart = By.xpath("//a[contains(text(),'Go to Cart')]");
    private final By lblProductName = By.xpath("//span[@class='a-truncate-cut']");
    private final By lblProductQuantity = By.xpath("//span[@class='a-dropdown-prompt']");
    private final By btnDelete = By.xpath("//input[@value='Delete']");
    private final By lblSubTotal = By.xpath("//span[@id='sc-subtotal-amount-activecart']");

    private final String txtAddedToCartMessage = "Added to Cart";

    public boolean isAddedToCartMessageDisplaying(){ //not working. need to check
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       return wait.until(ExpectedConditions.visibilityOfElementLocated(lblAddedToCart)).getText().contains(txtAddedToCartMessage);
       //Using contains keyword instead of equals or equalsIgnoreCase to overcome the issues related to empty spaces when capturing text content from a web element
    }
    public void clickOnGoToCartButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnGoToCart)).click();
    }

    public String getProductName(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lblProductName)).getText();
    }
    public String getQuantity(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lblProductQuantity)).getText();
    }
    public String getSubTotal(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lblSubTotal)).getText().trim();
        //Since it contains '$' it will get passed as a String
    }

    public void clickOnDeleteButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btnDelete)).click();
    }


}
