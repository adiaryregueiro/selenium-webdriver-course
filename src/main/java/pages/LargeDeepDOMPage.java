package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeDeepDOMPage {
    private final WebDriver driver;
    private final By large_table;

    public LargeDeepDOMPage(WebDriver driver) {
        this.driver = driver;
        this.large_table = By.id("large-table");
    }

    public void scrollToTable(){
        WebElement tableElement = driver.findElement(large_table);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script,tableElement);
    }
}
