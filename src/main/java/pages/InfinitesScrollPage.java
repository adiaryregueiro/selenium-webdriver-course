package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfinitesScrollPage {
    private final WebDriver driver;
    private final By textBlocks;

    public InfinitesScrollPage(WebDriver driver) {
        this.driver = driver;
        this.textBlocks = By.className("jscroll-added");
    }

    /**
     * Scrolls until paragraph with index specified is in view
     * @param index 1-based
     */
    public void scrollToParagraph(int index){
        String script = "window.scrollTo(0,document.body.scrollHeight)";
        var jsExecutor = (JavascriptExecutor)driver;
        while (getNumberOfParagrahsPresent()< index){
            jsExecutor.executeScript(script);
        }
    }

    private int getNumberOfParagrahsPresent(){
        return driver.findElements(textBlocks).size();
    }
}
