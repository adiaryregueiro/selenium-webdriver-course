package com.example.cursoselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickFormAuthentication(){
        clickLinkByLinkText("Form Authentication");
        return new LoginPage(driver);
    }

    public DropdrowPage clickDropDown()
    {
        clickLinkByXPath("//div[@id='content']/ul//a[@href='/dropdown']");
        return new DropdrowPage(driver);
    }

    public ForgotPasswordPage clickForgotPassword(){
        clickLinkByLinkText("Forgot Password");
        return new ForgotPasswordPage(driver);
    }

    public HoversPage clickHovers(){
        clickLinkByXPath("//a[@href='/hovers']");
        return new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPresses(){
       // clickLinkByLinkText("Key Presses");
        clickLinkByXPath("//a[@href='/key_presses']");
        return new KeyPressesPage(driver);
    }

    public HorizontalSliderPage clickHorizontalSlider(){
        clickLinkByXPath("//a[@href='/horizontal_slider']");
        return new HorizontalSliderPage(driver);
    }

    public AlertsPage clickAlerts(){
        clickLinkByXPath("//a[contains(@href, 'alerts')]");
        //clickLinkByLinkText("JavaScript Alerts");
        return new AlertsPage(driver);
    }

    public FileUploadPage clickFileUpload(){
        clickLinkByXPath("//a[@href='/upload']");
        return new FileUploadPage(driver);
    }

    public EntryAdPage clickEntryAd(){
        clickLinkByXPath("//a[@href='/entry_ad']");
        return new EntryAdPage(driver);
    }

    public void clickLinkByLinkText(String link){
        driver.findElement(By.linkText(link)).click();
    }

    public void clickLinkByXPath(String xpathExpression){
        driver.findElement(By.xpath(xpathExpression)).click();
    }

    public void clickLinkByCSSSelector(String cssSelector){
        driver.findElement(By.cssSelector(cssSelector)).click();
    }
}
