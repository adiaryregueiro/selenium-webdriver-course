package stepsdefs.frame;

import stepsdefs.base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiwyg(){
        var editorPage = homePage.clickWYSIWYGEditor();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tox-edit-area")));
        editorPage.clearTextArea();
        editorPage.setTextArea("Hello word Adiary");
//      editorPage.clickdecreaseIndention();
        assertEquals(editorPage.getTextFromEditor(),"Hello word Adiary", "Incorrect text message");
    }

    @Test
    public void testNestedFrames(){
        var nestedFrames = homePage.clickFramesPage().clickNestedFrames();
        assertEquals(nestedFrames.getLeftFrameText(), "LEFT", "Left frame text incorrect");
        assertEquals(nestedFrames.getBottomFrameText(), "BOTTOM", "Bottom frame text incorrect");
    }
}
