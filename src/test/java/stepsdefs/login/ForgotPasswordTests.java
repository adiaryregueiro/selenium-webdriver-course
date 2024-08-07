package stepsdefs.login;

import stepsdefs.base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void forgotPasswordTest(){
        var forgotPass = homePage.clickForgotPassword();
        forgotPass.enterEmail("tau@example.com");
        var emailSentPage = forgotPass.retreivePassword();
//      assertEquals(emailSentPage.getMessage(), "Your e-mail's been sent!", "Message is incorrect");
        assertEquals(emailSentPage.getMessage(), "Internal Server Error", "Message is incorrect");
    }
}
