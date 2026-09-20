package DAY2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class ExplicitWait {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();


        try {
            driver.get("file:///C:/Users/ccst/Desktop/SELENIUM/SeleniumMaterial/TestcasesClassAssignment-drivingLicenseUI.html");

            WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement message1 = explicitWait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))
            );



            if (message1.getText().equals("Welcome!!")) {
                System.out.println("Pass: Welcome message displayed correctly");
            } else {
                System.out.println("Fail: Message text mismatched.actual: " + message1.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}