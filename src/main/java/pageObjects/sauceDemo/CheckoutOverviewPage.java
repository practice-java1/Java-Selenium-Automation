package pageObjects.sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.PageBase;

public class CheckoutOverviewPage extends PageBase {

    @FindBy(className = "title")
    WebElement pageTitle;

    @FindBy(className = "summary_subtotal_label")
    WebElement itemPrice;

    @FindBy(className = "summary_tax_label")
    WebElement taxPrice;

    @FindBy(className = "summary_total_label")
    WebElement totalOrderPrice;

    @FindBy(id = "finish")
    WebElement finishButton;


    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String getPageTitle() {
        return pageTitle.getText();
    }

    public double getTotalPrice() {
        String itemPriceText = itemPrice.getText().replaceAll("[^0-9.]", "");
        String taxPriceText = taxPrice.getText().replaceAll("[^0-9.]", "");

        double itemPriceValue = Double.parseDouble(itemPriceText);
        double taxPriceValue = Double.parseDouble(taxPriceText);

        return itemPriceValue + taxPriceValue;
    }

    public void clickFinishButton() {
        finishButton.click();
    }
}
