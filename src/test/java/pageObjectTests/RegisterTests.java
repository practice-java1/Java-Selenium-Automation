package pageObjectTests;

import enums.RegisterFields;
import org.junit.Assert;
import org.junit.Test;
import pageObjects.RegisterPage;
import utils.TestBase;

import java.util.logging.Logger;

public class RegisterTests extends TestBase {

    RegisterPage registerPage = new RegisterPage(driver);
    static Logger log = Logger.getLogger(String.valueOf(RegisterTests.class));

    @Test

    public void registerWithAllRequiredFieldsCompleted() {
        driver.get("https://testare-manuala.locdejoacapentruitsti.com/blog/register/");

        log.info("Entering the required fields");
        registerPage.enterRequiredFields(
                RegisterFields.USERNAME.getValue(),
                RegisterFields.EMAIL.getValue(),
                RegisterFields.PASSWORD.getValue(),
                RegisterFields.REPEAT_PASSWORD.getValue()
        );

        log.info("Clicking on the Register button");
        registerPage.clickRegisterButton();

        RegisterPage registerPage1 = new RegisterPage(driver);

        log.info("Verifying the success message");
        //Verificare a mesajului de succes folosind username-ul din enum
        Assert.assertEquals(
                "The account has not been successfully created!",
                "The account " + RegisterFields.USERNAME.getValue() + " has been successfully created!",
                registerPage.getSuccessMessage()
        );


    }
}
