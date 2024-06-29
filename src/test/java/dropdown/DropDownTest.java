package dropdown;

import com.example.cursoselenium.base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropDownTest extends BaseTests {

    @Test
    public void testSelectOption() {
       var dropDownPage =  homePage.clickDropDown();
       String option = "Option 1";
       dropDownPage.selectFromDropDown(option);
       var selectedOptions = dropDownPage.getDropDownOptions();
       assertEquals(selectedOptions.size(),1, "incorrect number of selected options");
       assertTrue(selectedOptions.contains(option), "option not selected");
    }
}
