package pages;

import config.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    @FindBy(id = "login2")
    private WebElement loginButton;

    @FindBy(id = "logout2")
    private WebElement logoutButton;

    @FindBy(id = "nameofuser")
    private WebElement welcomeUser;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openWebsite() {
        logger.info("Opening website");
        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    public LoginPage clickLogin() {
        logger.info("Clicking Login button");
        click(loginButton);
        return new LoginPage(driver);
    }

    public void clickLogout() {
        logger.info("Clicking Logout button");
        click(logoutButton);
    }

    public String getWelcomeText() {
        logger.info("Getting welcome message");
        return getText(welcomeUser);
    }

    public boolean isLoginButtonDisplayed() {
        logger.info("Checking Login button is displayed");
        return loginButton.isDisplayed();
    }
}