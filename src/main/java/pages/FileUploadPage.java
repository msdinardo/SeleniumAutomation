package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {

    WebDriver driver;
    By regularFileUpload = By.id("file-upload");
    By submitForm = By.id("file-submit");
    By dragAndDropUpload = By.id("drag-drop-upload");
    By uploadedFile = By.cssSelector("#uploaded-files");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillRegularUpload(String filePath)
    {
        driver.findElement(regularFileUpload).sendKeys(filePath);
    }

    public void submitForm()
    {
        driver.findElement(submitForm).click();
    }

    public String uploadedFileName()
    {
        return driver.findElement(uploadedFile).getText();
    }




}
