package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class Day_3_4_Action_Menu_Hover {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/ccst/Desktop/SELENIUM/SeleniumMaterial/actionClass_Menu.html");

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Actions actions = new Actions(driver);

            WebElement obj_menuItem = driver.findElement(By.id("productsMenu"));
            actions.moveToElement(obj_menuItem).perform();

            WebElement obj_subMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productsSubmenu")));

            if (obj_subMenu.isDisplayed()) {
                System.out.println("Pass: submenu " + obj_subMenu + "appeared on hover");
            } else {
                System.out.println("Fail: Result submenu " + obj_subMenu + "did not appear on hover");

            }
            actions.moveToElement(obj_menuItem).perform();
            WebElement obj_laptopLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("laptopsLink")));
            obj_laptopLink.click();
            String resultText = driver.findElement(By.id("result")).getText();
            if (resultText.equals("You clicked: Laptops")) {
                System.out.println("Pass: Laptop link clicked successfully, result:");

            } else {
                System.out.println("Fail: Laptop link click failed, result: ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }


}