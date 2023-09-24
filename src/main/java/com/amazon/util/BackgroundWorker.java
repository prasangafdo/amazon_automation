package com.amazon.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BackgroundWorker {

    private String price;
    protected static WebDriver driver;
    private final String baseURL = PropertyFileReader.getValue("baseurl");

    public void setPrice(String currency, double price, int quantity){
        this.price = currency+ price*quantity;
    }
    public String getPrice(){
        return price;
    }
    public void scrollDown(){
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }
    public void loadLandingPage(String browser){
   /*
*/
        switch (browser) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                driver.get(baseURL);
                driver.manage().window().maximize();
//        driver.navigate().refresh();
                break;
            }
            case "edge": {
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();
//        options.addArguments("--headless");
                options.addArguments("--remote-allow-origins=*");
                driver = new EdgeDriver(options);
                driver.get(baseURL);
                driver.manage().window().maximize();
                break;
            }
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                driver.get(baseURL);
                driver.manage().window().maximize();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.get(baseURL);
                driver.manage().window().maximize();
                break;
        }
    }

}
