package keys;

import com.example.cursoselenium.base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KeysTest  extends BaseTests {

    @Test
    public void testBackspace() {
        var keypage = homePage.clickKeyPresses();
        keypage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keypage.getResult(), "You entered: BACK_SPACE");
    }

    @Test
    public void testArroba() {
        var keypage = homePage.clickKeyPresses();
        keypage.enterArroba();
        assertEquals(keypage.getResult(), "You entered: 2");
    }
}
