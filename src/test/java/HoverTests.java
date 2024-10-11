import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.TestBase;

public class HoverTests extends TestBase {

    @Test
    public void checkIfTheColorIsChangingAtHoverAction() {
        driver.get("https://testare-manuala.locdejoacapentruitsti.com/blog/contact/");

        WebElement titlePage = driver.findElement(By.linkText("My CMS"));
        String initialColour = titlePage.getCssValue("color");
        String expectedColor = convertCodesToString("48, 48, 48", "1");

        Assert.assertEquals("The initial color is wrong", expectedColor, initialColour);

        Actions hover = new Actions(driver);
        Action mouseOver = hover.moveToElement(titlePage).build();
        mouseOver.perform();

        String hoverColor = titlePage.getCssValue("color");
        String expectedHoverColor = convertCodesToString("238, 51, 51", "1");
        Assert.assertEquals("The hover color is wrong", expectedHoverColor, hoverColor);

    }

    //rgba(48, 48, 48, 1)
    private String convertCodesToString(String colourCode, String number) {
        return "rgba(" + colourCode + ", " + number + ")";

    }
}
