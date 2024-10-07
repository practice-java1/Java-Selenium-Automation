package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends PageBase {

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenuElement;


    public DropDownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



   /* public int getNumberOfValuesFromOldSelectMenu(){
        return oldSelectMenuDD.getOptions().size();
    }

    */
}
