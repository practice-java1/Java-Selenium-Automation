package pageObjectTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageObjects.ContactPage;
import utils.TestBase;

import java.util.logging.Logger;

public class ContactTests extends TestBase {

    ContactPage contactPage = new ContactPage(driver);
    static Logger log = Logger.getLogger(String.valueOf(ContactTests.class));

    private final String ERROR_MESSAGE = "There was an error trying to send your message. Please try again later.";

    @Test
    public void checkErrorMessageDisplayedAfterAllFieldsAreCompleted() throws InterruptedException {
        driver.get("https://testare-manuala.locdejoacapentruitsti.com/blog/contact/");
        WebElement topicElement = driver.findElement(By.xpath("//*[@name='Select']"));
        Select selectTopicDropDown = new Select(topicElement);


        log.info("Completing the fields");
        contactPage.enterYourName("Ioana");
        contactPage.enterYourEmail("ioana@gmail.com");
        contactPage.enterYourPhone("0745879890");
        contactPage.enterSubject("Testing");
        contactPage.enterYourMessage("Automation testing with Selenium");

        selectTopicDropDown.selectByIndex(2);
        String selectedValue = selectTopicDropDown.getFirstSelectedOption().getText();
        log.info("Selected topic: " + selectedValue);

        contactPage.clickOnWhereDidYouFindUs();
        contactPage.clickOnYourProfessionArea();
        contactPage.clickSendButton();

        Thread.sleep(4000);

        Assert.assertEquals("Error message is not displayed", ERROR_MESSAGE, contactPage.displayErrorMessage());
        String actualErrorMessage = contactPage.displayErrorMessage();
        System.out.println("Actual error message: " + actualErrorMessage);


    }

}
