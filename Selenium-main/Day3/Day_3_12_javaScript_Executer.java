package Day3;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Day_3_12_javaScript_Executer {
    public static void main(String args[]){
        WebDriver driver = new ChromeDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            double zoomLevelBefore =(double) js.executeScript("return window.devicePixelRatio;");
            System.out.println("Current zoom ratio" + zoomLevelBefore);

            Actions actions = new Actions(driver);
            actions.keyDown(Keys.CONTROL).sendKeys(Keys.ADD).keyUp(Keys.CONTROL).perform();
            Thread.sleep(2000);
            double zoomLevelAfter = (double) js.executeScript("return window.devicePixelRatio;");
            System.out.println("Zoom ratio after zooming in: " + zoomLevelAfter);


        }catch (InterruptedException e) {
            e.printStackTrace();
        }catch (JavascriptException e) {
            System.out.println("JavaScript execution error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
