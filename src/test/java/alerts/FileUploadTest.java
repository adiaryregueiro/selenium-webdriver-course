package alerts;

import com.example.cursoselenium.base.BaseTests;
import com.example.cursoselenium.pages.FileUploadPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTests {


    @Test
    public void testFileUpload() {
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("C:\\Users\\Erick\\AquaProjects\\CursoSelenium\\resources\\photo3.jpg");
        assertEquals(uploadPage.getUploadedFiles(),"photo3.jpg", "Uploaded files incorrect");
    }
}
