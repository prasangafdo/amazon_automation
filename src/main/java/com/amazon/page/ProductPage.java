package com.amazon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductPage extends LandingPage{

    private final By lblUnitPrice = By.xpath("//span[@class='a-size-base a-color-price a-color-price']");
    private final By lblProductTitle = By.xpath("//span[@id='productTitle']");
    private final By drpDwnQuantity = By.xpath("//span[@class='a-dropdown-container']");
    private final By drpDwnQuantityValue = By.xpath("//li[@aria-labelledby='quantity_val']/a");
    private final By btnAddToCart = By.xpath("//input[@id='add-to-cart-button']");

    private String unitPrice;
    private static Logger logger = Logger.getLogger(LandingPage.class.getName());

    public void setUnitPrice(){
        this.unitPrice = driver.findElement(lblUnitPrice).getText();
        unitPrice = unitPrice.replace("$",""); //Removing currency indicator
    }

    public String getUnitPrice(){
        return unitPrice;
    }
    public String getProductTitle(){
        return driver.findElement(lblProductTitle).getText();
    }
    public void clickOnQuantityDropDown(){
         driver.findElement(drpDwnQuantity).click();
    }
    public void selectQuantity(int quantity){
        String tempElement = String.valueOf(drpDwnQuantityValue).replace("val", String.valueOf(quantity-1));
        String[] temp = tempElement.split("By.xpath:");
        driver.findElement(By.xpath(temp[1])).click();
        //Adding correct quantity to xpath
    }
    public void clickOnAddToCartButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart)).click();
        logger.log(Level.INFO, "Product added to the cart");
    }


}
