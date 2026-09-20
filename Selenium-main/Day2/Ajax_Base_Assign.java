package DAY2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ajax_Base_Assign {
    public static void main(String[] args) {
        WebDriver obj_driver = new ChromeDriver();
        try {
            obj_driver.get("C:/Users/ccst/Desktop/SELENIUM/SeleniumMaterial/challenge_AjaxPage.html");


            WebDriverWait wait = new WebDriverWait(obj_driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("spinner")));

            WebElement loadQuoteBtn = obj_driver.findElement(By.id("loadQuoteBtn"));
            loadQuoteBtn.click();

            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("quoteLoading")));
            WebElement quoteBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quoteBox")));
            if(quoteBox.isDisplayed()) {
                System.out.println("Quote is displayed: ");
            }
            System.out.println("Quote text: " + quoteBox.getText());
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            obj_driver.quit();
        }
    }
}