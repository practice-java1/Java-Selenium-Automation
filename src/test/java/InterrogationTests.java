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
    public void getElementUsingId() {
        driver.get("https://www.limeroad.com/");

        WebElement womenButton = driver.findElement(By.id("shopWomen"));

        log.info("Clicking the 'Women' button in order to get the page with the products.");
        womenButton.click();

        log.info("Checking if the button name is 'Women'");
        Assert.assertEquals("The button name is wrong", "Women", womenButton.getText());
    }
}
