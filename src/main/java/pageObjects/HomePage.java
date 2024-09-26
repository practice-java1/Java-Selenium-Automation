package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{
    @FindBy(xpath="//*[@id='menu-item-126']")
    WebElement logOutButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLogOutButtonText() {
        WebElement logOutButtonElement = driver.findElement((By) logOutButton);
       return logOutButtonElement.getText();
    }
}
