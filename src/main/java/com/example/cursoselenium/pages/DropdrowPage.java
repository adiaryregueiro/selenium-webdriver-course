package com.example.cursoselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class DropdrowPage {

    private WebDriver driver;
    private By dropDown = By.id("dropdown");

    public DropdrowPage(WebDriver driver) {
        this.driver = driver;
    }

    private Select findDropDownElement() {
        return new Select(driver.findElement(dropDown));
    }

    public void selectFromDropDown(String option) {
        findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getDropDownOptions() {
//        List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
//        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
        var elements = findDropDownElement().getAllSelectedOptions();
        return elements
                .stream()
                .map(WebElement::getText)
                .collect(toList());
    }
}
