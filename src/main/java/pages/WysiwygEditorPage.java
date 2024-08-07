package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {
    private WebDriver driver;
    private String editorIFrameId =  "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndentButton = By.cssSelector("#mceu_12 button");

     public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    public String getTextFromEditor(){
        switchToEditArea();
        String result = driver.findElement(textArea).getText();
        switchToMainArea();
        return result;
    }

    public void clickdecreaseIndention(){
        driver.findElement(decreaseIndentButton).click();
    }

    private void switchToEditArea(){
         driver.switchTo().frame(editorIFrameId);
    }

    private void switchToMainArea(){
         driver.switchTo().parentFrame();
    }
}
