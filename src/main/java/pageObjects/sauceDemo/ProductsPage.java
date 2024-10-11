package pageObjects.sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.PageBase;

public class ProductsPage extends PageBase {

    @FindBy(className = "title")
    WebElement titlePageElement;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartButton;

    @FindBy(className = "shopping_cart_link")
    WebElement cartButton;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductTitlePage() {
        return titlePageElement.getText();
    }

    public void addProductToCart() {
        addToCartButton.click();
    }

    public void openCartPage() {
        cartButton.click();
    }
}
