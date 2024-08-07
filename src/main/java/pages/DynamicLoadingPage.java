package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private final WebDriver driver;
    private final String linkXpath_Format;
    private final By link_Example1;
    private final By linkExample2;

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        this.linkXpath_Format = ".//a[contains(text(), '%s')]";
        this.link_Example1 = By.xpath(String.format(linkXpath_Format, "Example 1"));
        this.linkExample2 = By.xpath(String.format(linkXpath_Format,"Example 2"));
    }

    public DynamicLoadingExample1Page clickExample1(){
        driver.findElement(link_Example1).click();
        return new DynamicLoadingExample1Page(driver);
    }

    public DynamicLoadingExample2Page clickExample2(){
        driver.findElement(linkExample2).click();
        return new DynamicLoadingExample2Page(driver);
    }

     public DynamicLoadingExample2Page rightClickOnExample2Link(){
        driver.findElement(linkExample2).sendKeys(Keys.CONTROL, Keys.RETURN);
        return new DynamicLoadingExample2Page(driver);
    }
}
