package tests;

import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        HomePage homePage = new HomePage(driver);

        homePage.openWebsite();

        LoginPage loginPage = homePage.clickLogin();

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        Assert.assertEquals(
                homePage.getWelcomeText(),
                "Welcome Evgeni@94"
        );

        homePage.clickLogout();

        Assert.assertTrue(
                homePage.isLoginButtonDisplayed()
        );
    }
}