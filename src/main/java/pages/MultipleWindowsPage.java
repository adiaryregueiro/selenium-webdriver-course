package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage {
    private final WebDriver driver;
    private final By clickHereLink;

    public MultipleWindowsPage(WebDriver driver) {
        this.driver = driver;
        this.clickHereLink = By.linkText("Click Here");
    }

    public void clickHere(){
        driver.findElement(clickHereLink).click();
    }


}
