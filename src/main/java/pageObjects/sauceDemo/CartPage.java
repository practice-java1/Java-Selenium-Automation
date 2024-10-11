package pageObjects.sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.PageBase;

public class CartPage extends PageBase {

    @FindBy(className = "inventory_item_name")
    WebElement productDescriptionElement;

    @FindBy(className = "cart_quantity")
    WebElement productQuantityElement;

    @FindBy(className = "inventory_item_price")
    WebElement productPrice;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductDescription() {
        return productDescriptionElement.getText();
    }

    public int getProductQuantity(){
        return Integer.parseInt(productQuantityElement.getText());
    }

    public String getProductPrice(){
        return productPrice.getText();
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

}
