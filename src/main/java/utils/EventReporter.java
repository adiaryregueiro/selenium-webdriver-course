package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.Arrays;

public class EventReporter implements WebDriverListener {

    public void beforeClick(WebElement element) {
        System.out.println("Clicking on " + element.getText());
    }

    public void afterGet(WebDriver driver, String url) {
        System.out.println("Navigated  to: " + url);
    }

    public void afterQuit(WebDriver driver) {
        System.out.println("Test completed");
    }

    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.println("Typing in an element: " + Arrays.toString(keysToSend));
    }
}
