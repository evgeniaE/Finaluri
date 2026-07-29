package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(ProductPage.class);

    @FindBy(linkText = "Samsung galaxy s6")
    private WebElement samsungGalaxyS6;

    @FindBy(linkText = "Add to cart")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void openProduct() {
        logger.info("Opening Samsung Galaxy S6 product page");
        click(samsungGalaxyS6);
    }

    public void addToCart() {
        logger.info("Clicking Add to cart");
        click(addToCartButton);
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