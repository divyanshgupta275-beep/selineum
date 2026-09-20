package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day_3_5_Drag_And_Drop {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/ccst/Desktop/SELENIUM/SeleniumMaterial/dragDrop.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement item1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item1")));
        WebElement targetContainer = driver.findElement(By.id("targetContainer"));

        actions.dragAndDrop(item1, targetContainer).perform();

        String result1 = driver.findElement(By.id("result")).getText();
        System.out.println("after drag and drop" + result1);


        if (result1.contains("write manual test case and moveTo Done")) {
            System.out.println("PASS: Drag and drop worked with drag and drop method");
        } else {
            System.out.println("FAIL: Drag and drop did not work with drag and drop method");
        }


        WebElement item2 = driver.findElement(By.id("item2"));
        actions.clickAndHold(item2)
                .moveToElement(targetContainer)
                .pause(Duration.ofSeconds(2))
                .release()
                .build()
                .perform();

        String result2 = driver.findElement(By.id("result")).getText();
        System.out.println("after manual click - and hold - move - release" + result2);

        if (result2.contains("Define Entry and Exit Criteria and moved to Done")) {
            System.out.println("PASS: Drag and drop worked with manual actions sequence");
        } else {
            System.out.println("FAIL: manual actions sequence did not work for drag and drop");
        }

        driver.quit();

    }
}
