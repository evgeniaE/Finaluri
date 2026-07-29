package tests;

import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class WrongUsernameTest extends BaseTest {

    @Test
    public void wrongUsernameTest() {

        HomePage homePage = new HomePage(driver);

        homePage.openWebsite();

        LoginPage loginPage = homePage.clickLogin();

        loginPage.login(
                "WrongUser999999999",
                "WrongPassword123"
        );

        String alertText = loginPage.getAlertText();

        Assert.assertEquals(
                alertText,
                "User does not exist."
        );

        loginPage.acceptAlert();
    }
}