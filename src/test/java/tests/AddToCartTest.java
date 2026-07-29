package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCartTest() {

        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        homePage.openWebsite();

        productPage.openProduct();

        productPage.addToCart();

        String alertText = productPage.getAlertText();

        Assert.assertEquals(
                alertText,
                "Product added"
        );

        productPage.acceptAlert();
    }
}