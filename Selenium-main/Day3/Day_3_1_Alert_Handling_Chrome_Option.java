package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Day_3_1_Alert_Handling_Chrome_Option {

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("unhandledPromptBehavior", "accept");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        try{
            driver.get("file:///C:/Users/ccst/Desktop/SELENIUM/SeleniumMaterial/javascriptAlerts.html");
            Thread.sleep(2000);
            driver.findElement(By.id("alertBtn")).click();
            Thread.sleep(1000);
            System.out.println("page title is " + driver.getTitle());
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();

        }
    }
}
