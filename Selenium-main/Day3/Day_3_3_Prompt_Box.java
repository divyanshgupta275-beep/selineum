package Day3;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day_3_3_Prompt_Box {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Use WebDriverWait instead of Thread.sleep for stable execution
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("file:///C:/Users/ccst/Desktop/SELENIUM/SeleniumMaterial/javascriptAlerts.html");
            Thread.sleep(1000);
            // 1. Click the button that triggers the prompt box
            // (Assuming the button ID for the prompt box is 'promptBtn')
            driver.findElement(By.id("promptBtn")).click();
            Thread.sleep(1000);
            // 2. Wait for the prompt alert to appear and switch to it
            Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());

            // 3. Type text into the prompt box
            promptAlert.sendKeys("Avinash Kanade");
            Thread.sleep(1000);
            // 4. Accept the prompt (Clicks OK)
            promptAlert.accept();

            // 5. Read and print the result displayed on the page
            String resultText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("promptResult"))).getText();
            Thread.sleep(1000);
            System.out.println("Prompt Result Output: " + resultText);
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
