package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    private By emailField =  By.id("email");
    private By passwordField = By.xpath("//*[@id='form_submit']");
    private By retrievePasswordButton = By.id("form_submit");
//    private By passwordField = By.xpath("//*[@id='form_submit']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterEmail(String email) {
       driver.findElement(emailField).sendKeys(email);
    }

    public EmailSentPage retreivePassword() {
        driver.findElement(passwordField).click();
        return new EmailSentPage(driver);
    }
}
