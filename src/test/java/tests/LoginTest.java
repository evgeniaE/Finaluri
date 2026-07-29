package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import config.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

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
    }
}