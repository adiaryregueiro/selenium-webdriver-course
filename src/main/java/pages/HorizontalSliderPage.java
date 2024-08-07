package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HorizontalSliderPage {
    WebDriver driver;
    private By slider = By.xpath("//input[@type='range']");
    private By sliderValue = By.xpath("//span[@id='range']");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSliderField() {
        return driver.findElement(slider);
    }

    public void setSliderValue(String value) {

        while (!getSliderValue().equals(value)) {
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getSliderValue() {
        return driver.findElement(sliderValue).getText();
    }
}
