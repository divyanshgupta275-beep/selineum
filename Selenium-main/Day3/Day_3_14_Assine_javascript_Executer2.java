package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Day_3_14_Assine_javascript_Executer2{

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            driver.get("file:///C:/Users/ccst/Desktop/SELENIUM/SeleniumMaterial/TestcasesClassAssignment-drivingLicenseUI.html");

            WebElement objhandel = driver.findElement(By.xpath("//h2[text()='Driving License Application']"));


            js.executeScript("arguments[0].style.backgroundColor = 'yellow';", objhandel);
            js.executeScript("arguments[0].style.border = '3px solid black';", objhandel);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // driver.quit();
        }
    }
}