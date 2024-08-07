package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private final WebDriver driver;
    private final String topFrame;
    private final String leftFrame;
    private final String bottomFrame;
    private final By body;

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
        this.topFrame = "frame-top";
        this.leftFrame = "frame-left";
        this.bottomFrame = "frame-bottom";
        this.body = By.tagName("body");
    }

    private void switchToFrame(String fraseName){
        driver.switchTo().frame(fraseName);
    }

    public String getLeftFrameText(){
        switchToFrame(topFrame);
        switchToFrame(leftFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame(); //exit left to top
        driver.switchTo().parentFrame(); //exit top to main
        return text;
    }

    public String getBottomFrameText(){
        switchToFrame(bottomFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame(); //exit top to main
        return text;
    }

    private String getFrameText(){
        return driver.findElement(body).getText();
    }
}
