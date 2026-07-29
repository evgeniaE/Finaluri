package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(id = "loginusername")
    private WebElement usernameField;

    @FindBy(id = "loginpassword")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {

        logger.info("Entering username");
        sendKeys(usernameField, username);

        logger.info("Entering password");
        sendKeys(passwordField, password);

        logger.info("Clicking Log in button");
        click(loginButton);

        logger.info("Login button clicked");
    }

    public String getAlertText() {

        logger.info("Getting alert text");

        wait.until(ExpectedConditions.alertIsPresent());

        String alertText = driver.switchTo().alert().getText();

        logger.info("Alert text: " + alertText);

        return alertText;
    }

    public void acceptAlert() {

        logger.info("Accepting alert");

        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();
    }
}