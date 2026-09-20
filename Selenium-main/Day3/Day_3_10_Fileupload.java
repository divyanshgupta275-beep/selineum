package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day_3_10_Fileupload {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/ccst/Desktop/SELENIUM/SeleniumMaterial/fileUpload.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fileInput")));


        String filePath = "C:\\Users\\ccst\\Pictures\\cdac.png";
        fileInput.sendKeys(filePath);
        Thread.sleep(2000);
        System.out.println("File uploaded successfully: ");


        WebElement fileNameLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fileName")));
        if (fileNameLabel.getText().contains("cdac.png")){
            System.out.println("PASS: File name displayed correctly: " + fileNameLabel.getText());
        } else {
            System.out.println("FAIL: File name not displayed correctly" + fileNameLabel.getText());
        }


        WebElement uploadButton = driver.findElement(By.id("uploadBtn"));
        uploadButton.click();
        Thread.sleep(2000);
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));

        String expectedMessage = "File 'cdac.png' uploaded successfully!";
        if (result.getText().equals(expectedMessage)) {
            System.out.println("PASS: File uploaded successfully, result: " + result.getText());
        } else {
            System.out.println("FAIL: File upload failed, result: " + result.getText());
        }
//        driver.quit();
    }
}
