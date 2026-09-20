package DAY2;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import java.time.Duration;

public class FluentWait_Demo {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("file:///C:/Users/ccst/Desktop/SELENIUM/SeleniumMaterial/TestcasesClassAssignment-drivingLicenseUI.html");


            WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement submitBtn = explicitWait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))
            );
            System.out.println("Pass: Submit button is present and clickable");


            Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(4))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class);

            WebElement fullNameInput = fluentWait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("fullname"))
            );


            if (fullNameInput.isDisplayed()) {
                System.out.println("Pass: Full Name input field verified on page");
            } else {
                System.out.println("Fail: Full Name input field not visible");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}