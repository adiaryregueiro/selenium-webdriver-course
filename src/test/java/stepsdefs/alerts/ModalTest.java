package stepsdefs.alerts;

import stepsdefs.base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ModalTest  extends BaseTests {

    @Test
    public void testModal() {
        var entryAdPage = homePage.clickEntryAd();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal")));
        assertEquals(entryAdPage.getModalTittle(),"THIS IS A MODAL WINDOW", "Incorrect Modal tittle");
        assertEquals(entryAdPage.getModalBody(),"It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something or disable their ad blocker).","Incorrect Modal body");
        assertEquals(entryAdPage.getModalFooter(),"Close", "Incorrect Modal footer");
    }
}
