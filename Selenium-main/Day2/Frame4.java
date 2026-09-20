package DAY2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Frame4 {
    public static void main(String[] args) {
        try {


            WebDriver driver = new ChromeDriver();
            driver.get("file:///C:/Users/ccst/Desktop/SELENIUM/SeleniumMaterial/iFrameDemo.html");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement outerFrame = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.id("outerFrame"))
            );
            driver.switchTo().frame(outerFrame);

            WebElement innerFrame = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.id("innerFrame"))
            );
            driver.switchTo().frame(innerFrame);

            WebElement innerFrameBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("innerFrameBtn"))
            );
            innerFrameBtn.click();
            System.out.println("Inner button clicked");

            driver.switchTo().defaultContent();

            WebElement mainBtn = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("mainBtn"))
            );

            if (mainBtn.isDisplayed()) {
                System.out.println("MainButton is clicked ");
            }

            Thread.sleep(2000);
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }
}