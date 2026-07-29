package tests;

import driver.DriverFactory;
import listeners.ExtentReportListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(ExtentReportListener.class)
public class BaseTest {

    protected WebDriver driver;

    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp() {

        logger.info("Starting browser");

        driver = DriverFactory.getDriver();

        logger.info("Browser started");
    }

    @AfterMethod
    public void tearDown() {

        logger.info("Closing browser");

        DriverFactory.quitDriver();

        logger.info("Browser closed");
    }
}