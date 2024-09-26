package pageObjectTests;

import org.junit.Assert;
import org.junit.Test;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import utils.TestBase;

import java.util.logging.Logger;

public class LogInTests extends TestBase {
    LogInPage logInPage = new LogInPage(driver);
    static Logger log = Logger.getLogger(String.valueOf(LogInTests.class));

    @Test
    public void logInWithValidCredentials() {
        driver.get("https://testare-manuala.locdejoacapentruitsti.com/blog/login/");

        log.info("Entering the valid credentials");

        logInPage.enterUserName("IoanaBulgariu");
        logInPage.enterPassword("Test1234");

        log.info("Clicking on the LogIn button");
        logInPage.clickLoginButton();

        HomePage homePage = new HomePage(driver);
        Assert.assertEquals("Log out button is not available", "Logout", homePage.getLogOutButtonText());
    }
}
