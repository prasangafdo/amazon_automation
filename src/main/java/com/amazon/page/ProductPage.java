package com.amazon.page;

import org.openqa.selenium.By;

public class ProductPage extends LandingPage{

    private final By lblUnitPrice = By.xpath("//div[@id='booksHeaderSection']//*[contains(text(),'$')] | //span[contains(@class,'a-text-price')]|//div[@id='corePriceDisplay_desktop_feature_div']");
    private final By lblProductTitle = By.xpath("//span[@id='productTitle']");


    public String getUnitPrice(){
        return driver.findElement(lblUnitPrice).getText();
    }

    public String getProductTitle(){
        return driver.findElement(lblProductTitle).getText();
    }
}
