package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Day_3_7_Assine_Actions_Contaxt_Menu {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();

        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);


        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        try {
            driver.get("file:///C:/Users/ccst/Desktop/SELENIUM/SeleniumMaterial/javascriptAlerts.html");
            // Show Alert
            driver.findElement(By.id("alertBtn")).click();
            Thread.sleep(2000);

            System.out.println("Title : " + driver.getTitle());
            Thread.sleep(2000);

            //show conform

            Thread.sleep(2000);

            driver.findElement(By.id("confirmBtn")).click();
            Thread.sleep(2000);

            System.out.println("Title : " + driver.getTitle());
            Thread.sleep(2000);



            // Prompt
            driver.findElement(By.id("promptBtn")).click();
            Thread.sleep(2000);

            System.out.println("Title : " + driver.getTitle());
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}