package pageObjects.sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.PageBase;

public class CheckOutPage extends PageBase {

    @FindBy(className = "title")
    WebElement titlePageElement;

    @FindBy(id = "first-name")
    WebElement firstNameField;

    @FindBy(id = "last-name")
    WebElement lastNameField;

    @FindBy(id = "postal-code")
    WebElement postalCodeField;

    @FindBy(id = "continue")
    WebElement continueButton;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return titlePageElement.getText();
    }

    public void enterFirstName(String firstname) {
        firstNameField.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        lastNameField.sendKeys(lastname);
    }

    public void enterPostalCode(int postalCode) {
        postalCodeField.sendKeys(String.valueOf(postalCode));
    }

    public void clickContinueButton() {
        continueButton.click();
    }

}
