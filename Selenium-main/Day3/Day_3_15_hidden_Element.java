package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day_3_15_hidden_Element {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/ccst/Desktop/SELENIUM/SeleniumMaterial/hiddenElementJavascriptExecutor.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement scrllTargetbtn = driver.findElement(By.id("scrollTargetBtn"));
        WebElement hiddenBtn = driver.findElement(By.id("hiddenBtn"));

        Thread.sleep(2000);

        // Standard click will throw ElementNotInteractableException on hidden elements
        try {
            hiddenBtn.click();
            System.out.println("click() succeeded on hidden element");
        } catch (Exception e) {
            System.out.println("click() failed on a hidden element: " + e.getClass().getSimpleName());
        }

        Thread.sleep(2000);

        // Corrected JS click syntax
        js.executeScript("arguments[0].click();", hiddenBtn);

        // Corrected DOM property from textContain to textContent
        String hiddenText = (String) js.executeScript("return arguments[0].textContent;", hiddenBtn);
        System.out.println("hidden button text: " + hiddenText);

        Thread.sleep(2000);

        // Verify result text (ensure "doorstep" matches exact text in HTML file)
        String result2 = driver.findElement(By.id("result")).getText();
        if (result2.equals("Hey Your Trasure will be at your doorstep, wait until TOMORROW !")) {
            System.out.println("PASS: hidden button click correctly -> " + result2);
        } else {
            System.out.println("FAIL: result mismatch -> " + result2);
        }

        Thread.sleep(2000);
        driver.quit();
    }
}