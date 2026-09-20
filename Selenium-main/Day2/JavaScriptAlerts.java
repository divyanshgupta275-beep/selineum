package DAY2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptAlerts {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("file:///C:/Users/ccst/Desktop/SELENIUM/SeleniumMaterial/javascriptAlerts.html");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            //sample alert

            driver.findElement(By.id("alertBtn")).click();
            Alert Samplealert = wait.until(ExpectedConditions.alertIsPresent());
            String alerttext = Samplealert.getText();
            System.out.println("Alert text  " + alerttext);
            Samplealert.accept();
            String alertres = driver.findElement(By.id("alertResult")).getText();


            if (alertres.equals("Alert is shown and accepted")){
                System.out.println("Pass");
            }else {
                System.out.println("Fail to get Alert");
            }

            // conformation
            driver.findElement(By.id("confirmBtn")).click();
            Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());

            System.out.println("Confirm text  " + confirmAlert.getText());
            confirmAlert.accept();

            String confirmRes = driver.findElement(By.id("confirmResult")).getText();

            if (confirmRes.equals("You clicked ")) {
                System.out.println("Confirm Accept Test Pass");
            } else {
                System.out.println("Confirm Accept Test Fail");
            }

            // prompt

            driver.findElement(By.id("promptBtn")).click();
            Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());

            System.out.println("Prompt text " + promptAlert.getText());
            String inputText = "Selenium Tester";
            promptAlert.sendKeys(inputText);
            promptAlert.accept();

            String promptRes = driver.findElement(By.id("promptResult")).getText();

            if (promptRes.equals("You entered " + inputText)) {
                System.out.println("Prompt Accept Test Pass");
            } else {
                System.out.println("Prompt Accept Test Fail");
            }
        }


        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }
}
