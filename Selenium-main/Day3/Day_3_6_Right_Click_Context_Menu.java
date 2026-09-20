package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class Day_3_6_Right_Click_Context_Menu {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/ccst/Desktop/SELENIUM/SeleniumMaterial/rightClickContextMenuInteraction.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement targetBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("targetBox")));

        actions.contextClick(targetBox).perform();

        WebElement contextMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contextMenu")));
        if (contextMenu.isDisplayed()) {
            System.out.println("Pass: Context menu appeared on right click");
        } else {
            System.out.println("Fail: Context menu did not appear on right click");
        }


        WebElement deleteOption = wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteOption")));
        deleteOption.click();

        String result = driver.findElement(By.id("result")).getText();
        if (result.equals("You selected: Delete")) {
            System.out.println("Pass: Delete option selected correctly" + result);
        } else {
            System.out.println("Fail: Delete option selection failed" + result);
        }


    }
}


