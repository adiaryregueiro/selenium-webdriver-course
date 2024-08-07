package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

public class DynamicLoadingExample1Page {
    private final WebDriver driver;
    private final By startButton;
    private final By loadingIndicator;
    private final By finishText;

    public DynamicLoadingExample1Page(WebDriver driver) {
        this.driver = driver;
        this.startButton = By.cssSelector("#start button");
        this.loadingIndicator = By.id("loading");
        this.finishText = By.id("finish");
    }

    public void clickStart(){
        driver.findElement(startButton).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait until loading indicator is visible
//        wait.until(ExpectedConditions.invisibilityOf(
//                driver.findElement(loadingIndicator)));

        /**
         * In addition to indicating the timeout, you can also tell it how often it should poll.
         * And then also you can specify any exceptions that you want it to ignore.
         * */
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.invisibilityOf(
                driver.findElement(loadingIndicator)));
    }

    public String getLoadedText(){
        return driver.findElement(finishText).getText();
    }
}
