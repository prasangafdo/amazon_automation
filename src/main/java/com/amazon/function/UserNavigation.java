package com.amazon.function;


import com.amazon.page.LandingPage;

public class UserNavigation {
    static LandingPage landing = new LandingPage();

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
        landing.selectEnglishBooks();
    }
    public static String getSecondBookName() throws InterruptedException {
        landing.setBooksTitles();
        return landing.getBookNameOfTheSecondBook();
    }

    public static void closeBrowser(){
        landing.closeBrowser();
    }


}
