package com.amazon.function;


import com.amazon.page.LandingPage;

public class UserNavigation {
    private static final LandingPage landing = new LandingPage();

    public static void loadLoginPage(){
        landing.loadLandingPage();
    }
    public static boolean isAmazonLogoDisplaying(){
        return landing.isAmazonLogoDisplaying();
    }
    public static void selectBooksFromDropDown(){
        landing.selectBooksFromDropDown();
    }
    public static void searchByKeyword(String keyword){
        landing.searchByKeyword(keyword);
    }
    public static void selectReviewFourAndUp(){
        landing.selectReviewFourAndUp();
    }
    public static void selectEnglishBooks(){
        landing.scrollDown();
        landing.selectEnglishBooks();
    }
    public static void setBookTitles() throws InterruptedException {
        landing.setBooksTitles();
        landing.setBookNameOfTheSecondBook();
    }
    public static String getSecondBookName() {
        return landing.getBookNameOfTheSecondBook();
    }
    public static void navigateToBookDescription() throws InterruptedException {
        landing.navigateToBookDescription();
    }

    public static void closeBrowser(){
        landing.closeBrowser();
    }


}
