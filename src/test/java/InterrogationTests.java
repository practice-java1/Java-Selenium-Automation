import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.logging.Logger;

public class InterrogationTests extends TestBase {

    static Logger log = Logger.getLogger(String.valueOf(InterrogationTests.class));

    @Test
    public void returnSourcePageForeMAG() {
        driver.get("https://www.emag.ro");

        log.info("Getting the source page of the application. " + driver.getPageSource());
        driver.getPageSource();
    }

    @Test
    public void checkTheCartWhenThereAreNoProductsAdded() throws InterruptedException {
        final String MESSAGE_FOR_EMPTY_CART = "There are no items in your cart.";

        log.info("Getting the application page");
        driver.get("https://www.limeroad.com/");

        WebElement womenButton = driver.findElement(By.id("shopWomen"));
        womenButton.click();

        log.info("Getting the cart element");
        WebElement cartButton = driver.findElement(By.id("DesktopCart"));

        log.info("Clicking on the cart button in order to get the cart page.");
        cartButton.click();

        log.info("Asserting that we are in the right page.");
        Thread.sleep(2000);

        Assert.assertEquals("The Urls are different!", "https://www.limeroad.com/shopping_cart",
                driver.getCurrentUrl());

        WebElement messageForEmptyCartElement = driver.findElement(By.xpath("//*[contains(text(), 'in your cart')]"));
        String messageForEmptyCart = messageForEmptyCartElement.getText(); // "There are no items in your cart."

        log.info("Asserting that the right message is displayed when the cart is empty.");

        Assert.assertEquals("The message for empty cart is wrong", MESSAGE_FOR_EMPTY_CART,
                messageForEmptyCart);
    }

    @Test
    public void checkTheCartWhenThereAreProductsAdded() throws InterruptedException {
        log.info("Getting the application page");
        driver.get("https://www.limeroad.com/");

        WebElement womenButton = driver.findElement(By.id("shopWomen"));
        womenButton.click();

        Thread.sleep(5000);
        log.info("Clicking on the bag tab in order to get the products sub-categories");
        WebElement chicSelectsSection = driver.findElement(By.xpath("//*[contains(text(), 'Chic Selects')]"));
        chicSelectsSection.click();

        WebElement firstProduct = driver.findElement(By.id("21034131"));
    }
}
