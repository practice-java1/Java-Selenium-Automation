package pageObjects.sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.PageBase;

public class CheckoutCompletePage extends PageBase {

    @FindBy(className = "title")
    WebElement pageTitle;

    @FindBy(className = "complete-header")
    WebElement textMessage;

    @FindBy(id = "back-to-products")
    WebElement backHomeButton;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String getPageTitle() {
        return pageTitle.getText();
    }

    public String getThankYouForYourOrderMessage() {
        return textMessage.getText();
    }

    public void clickBackHomeButton(){
        backHomeButton.click();
    }
}
