package com.amazon.page;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LandingPage {

    private final By imgAmazon = By.xpath("//div[@id='nav-logo']");
    private final By drpDwnSearch = By.xpath("//select[@id='searchDropdownBox']");
    private final By txtSearch = By.xpath("//input[@id='twotabsearchtextbox']");
    private final By lblReviewFourAndUp = By.xpath("//section[contains(@aria-label,'4 Stars & Up')]");
    private final By chkBoxEnglish = By.xpath("//li[contains(@aria-label,'English')]//input");
    private final By lblBookTitle = By.xpath("//div[@class='sg-col-inner']//h2");
    private final By lnkToSecondBook = By.xpath("//span[contains(text(),'bookname')]/parent::a");
    private List<WebElement> bookTitles = new ArrayList<>();


    protected static WebDriver driver;
    private String baseURL = "https://www.amazon.com/ref=nav_logo";
    private String txtBookTitle;


    public void loadLandingPage(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(baseURL);
        driver.manage().window().maximize();
//        scaleWindowTo80Percent();
//        driver.navigate().refresh();

    }
    public void scaleWindowTo80Percent(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.body.style.zoom = '0.8'");
    }

    public boolean isAmazonLogoDisplaying(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(imgAmazon));
        return driver.findElement(imgAmazon).isDisplayed();
        //To check whether the user has navigated to the Amazon webpage
    }

    public void selectBooksFromDropDown(){
        //Selecting books from drop down
        Select selectCategory = new Select(driver.findElement(drpDwnSearch));
        selectCategory.selectByValue("search-alias=stripbooks-intl-ship");

    }

    public void searchByKeyword(String keyword){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtSearch)).sendKeys(keyword);
        driver.findElement(txtSearch).sendKeys(Keys.RETURN);
    }

    public void selectReviewFourAndUp(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblReviewFourAndUp)).click();
    }

    public void selectEnglishBooks(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(chkBoxEnglish)).click().build().perform();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(chkBoxEnglish)).click();
    }

    public void setBooksTitles() throws InterruptedException {
        Thread.sleep(1000); //Hard pause of 1 seconds to wait for the page to refresh after applying the filter.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); //Remaining waiting time will be handled by the explicit wait with a condition
        bookTitles = wait.until(ExpectedConditions.visibilityOfElementLocated(lblBookTitle)).findElements(lblBookTitle);
    }

    public List<WebElement> getBooksList(){
        return bookTitles;//Created this getter if we needed to access all the values of the books from another class
    }

    public void setBookNameOfTheSecondBook(){
        String.valueOf(lnkToSecondBook).replace("bookname",bookTitles.get(1).getText());
        this.txtBookTitle = bookTitles.get(1).getText();
    }


    public String getBookNameOfTheSecondBook(){
        return txtBookTitle;
    }

    public void navigateToBookDescription(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); //Waiting time will be handled by the explicit wait with a condition
        String tempElement = String.valueOf(lnkToSecondBook).replace("bookname",bookTitles.get(1).getText());
        String[] temp = tempElement.split("By.xpath:");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(temp[1]))).click();
//        driver.findElement(By.xpath(tempElement)).click();

    }

    public void scrollDown(){
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");

    }


    public void closeBrowser(){
        driver.quit();
    }
}
