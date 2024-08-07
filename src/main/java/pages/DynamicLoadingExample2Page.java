package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingExample2Page {
    private final WebDriver driver;
    private final By startButton;
    private final By loadingIndicator;
    private final By finishText;

    public DynamicLoadingExample2Page(WebDriver driver) {
        this.driver = driver;
        this.startButton = By.cssSelector("#start button");
        this.loadingIndicator = By.id("loading");
        this.finishText = By.id("finish");
    }

    public void clickStart() {
        driver.findElement(startButton).click();

        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(finishText));

       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(finishText));*/
    }

    public String getLoadedText() {
        return driver.findElement(finishText).getText();
    }

    public boolean isStartButtonDisplayed(){
        return driver.findElement(startButton).isDisplayed();
    }
}
