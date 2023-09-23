import com.amazon.function.UserNavigation;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class REG_TestAmazonWebApplication {

    private String searchKeyword = "automation";

    @BeforeMethod
    public void loadLandingPage(){
        UserNavigation.loadLoginPage();
    }

    @Test(priority = 1, description = "Verify the shopping cart feature")
    public void TestShoppingCartFeature() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(UserNavigation.isAmazonLogoDisplaying(),"Amazon logo is not displaying");
        UserNavigation.selectBooksFromDropDown();
        UserNavigation.searchByKeyword(searchKeyword);
        UserNavigation.selectReviewFourAndUp();
        System.out.println("====>"+UserNavigation.getSecondBookName());
        UserNavigation.navigateToBookDescription();

    ;
//        softAssert.assertTrue(UserNavigation.isSelectPlanTopicDisplaying(),"Select plan topic is not displaying");
//        UserNavigation.selectRs2000Plan();
//        softAssert.assertTrue(UserLogin.isLoginButtonDisplaying(),"Login page is not displaying");
        softAssert.assertAll();
    }


   // @AfterMethod
    public void closeBrowser(){
        UserNavigation.closeBrowser();
    }
}
