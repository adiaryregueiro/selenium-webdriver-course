package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntryAdPage {
    private WebDriver driver;
    private By modalTittle = By.xpath("//div[@class='modal-title']");
    private By modalBody = By.xpath("//div[@class='modal-body']");
    private By modalFooter = By.xpath("//div[@class='modal-footer']");

    public EntryAdPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getModalBody() {
       return driver.findElement(modalBody).getText();
    }

    public String getModalTittle() {
       return driver.findElement(modalTittle).getText();
    }

    public String getModalFooter() {
        return driver.findElement(modalFooter).getText();
    }

    public void closeModal() {
        driver.findElement(modalFooter).click();
    }
}
