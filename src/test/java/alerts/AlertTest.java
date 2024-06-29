package alerts;

import com.example.cursoselenium.base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTest extends BaseTests {

    @Test
    public void testAcceptAlert() {
        var alertPage = homePage.clickAlerts();
        alertPage.clicktriggerAlertButton();
        alertPage.accepAlert();
        assertEquals(alertPage.getResults(),"You successfully clicked an alert", "Result text incorrect");
    }

    @Test
    public void testGetTextFromAlert(){
        var alertPage = homePage.clickAlerts();
        alertPage.clicktriggerConfirmButton();
        String text = alertPage.alert_getText();
        alertPage.dismissAlert();
        assertEquals(text,"I am a JS Confirm","Incorrect text");
        assertEquals(alertPage.getResults(),"You clicked: Cancel","Incorrect text");
    }

    @Test
    public void testSetTextFromAlert(){
        var alertPage = homePage.clickAlerts();
        alertPage.clicktriggerPromptButton();
        String value = "Test typing in a prompt";
        alertPage.alert_setInput(value);
        alertPage.accepAlert();
        assertEquals(alertPage.getResults(),"You entered: " + value,"Incorrect text");
    }
}
