package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day_3_8_Keyboard_shortcuts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/ccst/Desktop/SELENIUM/SeleniumMaterial/keyboardShortcuts.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement sourceText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sourceText")));
        WebElement targetText =driver.findElement(By.id("targetText"));
        sourceText.click();

        actions.keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .perform();
        System.out.println("Selected all performed on source container");

        Thread.sleep(1000);
        actions.keyDown(Keys.CONTROL)
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .perform();
        System.out.println("Copy performed on source container");

        Thread.sleep(1000);
        targetText.click();
        actions.keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .perform();
        System.out.println("Paste performed on target container");
        Thread.sleep(1000);

        wait.until(ExpectedConditions.textToBe(By.id("result"),"Text copied successfully to Target !"));

        WebElement result = driver.findElement(By.id("result"));
        if (result.getText().equals("Text copied successfully to Target !")) {
            System.out.println("Pass: Text copied successfully");
        } else {
            System.out.println("Fail: Text copy failed" + result.getText());


        }
        driver.quit();
    }
}
