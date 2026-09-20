package Day3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day_3_2_Assine_Chrome_Option {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        // Optional: you can leave unhandledPromptBehavior out if handling explicitly,
        // or keep it as a safety fallback.

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Define an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("file:///C:/Users/ccst/Desktop/SELENIUM/SeleniumMaterial/javascriptAlerts.html");
            Thread.sleep(1000);
            // 1. Handle Confirmation Box
            driver.findElement(By.id("confirmBtn")).click();
            Thread.sleep(1000);
            // Wait for the alert/confirm to appear and switch to it
            Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Confirmation text: " + confirmAlert.getText());
            Thread.sleep(1000);
            confirmAlert.accept(); // Clicks OK (Use confirmAlert.dismiss() to click Cancel)

            // Verify the result message on the page
            String confirmResult = driver.findElement(By.id("confirmResult")).getText();
            Thread.sleep(1000);
            System.out.println("Confirm Result Message: " + confirmResult);
            Thread.sleep(1000);

            // 2. Handle Prompt Box (if you have one, e.g., promptBtn)
            // driver.findElement(By.id("promptBtn")).click();
            // Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());
            // promptAlert.sendKeys("Selenium User"); // Type text into prompt
            // promptAlert.accept();

            System.out.println("Page title is: " + driver.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}