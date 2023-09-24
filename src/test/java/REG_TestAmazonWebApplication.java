import com.amazon.function.Cart;
import com.amazon.function.Product;
import com.amazon.function.UserNavigation;
import com.amazon.function.Utility;
import com.amazon.util.BackgroundWorker;
import com.amazon.util.PropertyFileReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class REG_TestAmazonWebApplication {

    private final String searchKeyword = PropertyFileReader.getValue("searchkeyword");

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
        UserNavigation.selectEnglishBooks();
        UserNavigation.setBookTitles();
        UserNavigation.navigateToBookDescription();
        softAssert.assertEquals(UserNavigation.getSecondBookName(),Product.getProductTitle(),"Names are incorrect");
        Product.selectProductQuantity(Integer.parseInt(PropertyFileReader.getValue("quantity")));
        Product.addToCart();
        softAssert.assertTrue(Cart.isAddedToCartMessageDisplaying(),"Added to cart message is not displaying properly");
        Cart.clickOnGoToCartButton();

        System.out.println("====>"+ Cart.getProductName());
        System.out.println("product uni price====>"+ Product.getUnitPrice());
        System.out.println("quantity====>"+ Cart.getQuantity());
        System.out.println("sub====>"+ Cart.getSubTotal());
        System.out.println("product uni price double cast====>"+Double.parseDouble(Product.getUnitPrice()));

        Utility.setPrice(PropertyFileReader.getValue("currencytype"), Double.parseDouble(Product.getUnitPrice()),2);
        softAssert.assertEquals(Cart.getSubTotal(),Utility.getPrice(),"Price calculation error");
        Cart.deleteProduct();
        System.out.println("sub====>"+ Cart.getSubTotal());
        softAssert.assertEquals(Cart.getSubTotal(),PropertyFileReader.getValue("cartresetvalue"), "Shopping cart value has not been cleared");
        softAssert.assertAll();
    }


    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        UserNavigation.closeBrowser();
    }
}
