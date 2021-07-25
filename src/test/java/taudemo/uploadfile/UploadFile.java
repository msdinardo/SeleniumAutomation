package taudemo.uploadfile;

import org.testng.annotations.Test;
import pages.HomePage;
import taudemo.BaseTest;

import static org.testng.Assert.assertEquals;

public class UploadFile extends BaseTest {

    @Test
    public void uploadFile()
    {
        var fileUploadPage = homePage.clickFileUpload();
        fileUploadPage.fillRegularUpload("C:\\Users\\msdin\\Downloads\\download.jpg");
        fileUploadPage.submitForm();
        String uploadedFile = fileUploadPage.uploadedFileName();
        assertEquals(uploadedFile,"download.jpg");
    }
}
