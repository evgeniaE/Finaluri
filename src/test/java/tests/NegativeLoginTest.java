package tests;

import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class NegativeLoginTest extends BaseTest {

    @Test
    public void wrongPasswordTest() {

        HomePage homePage = new HomePage(driver);

        homePage.openWebsite();

        LoginPage loginPage = homePage.clickLogin();

        loginPage.login(
                ConfigReader.getProperty("username"),
                "wrongPassword"
        );

        String alertText = loginPage.getAlertText();

        Assert.assertEquals(
                alertText,
                "Wrong password."
        );

        loginPage.acceptAlert();
    }
}