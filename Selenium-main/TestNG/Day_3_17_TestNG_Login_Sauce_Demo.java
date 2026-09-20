package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day_3_17_TestNG_Login_Sauce_Demo {


    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/ccst/Desktop/SELENIUM/SeleniumMaterial/fileUpload.html");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        WebElement fileinput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("fileInput"))
        );

        String filepath = "C:\\Users\\ccst\\Pictures\\cdac.png";

        fileinput.sendKeys(filepath);

        System.out.println("file path send to input field ");


        WebElement filenamelable = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("fileName"))
        );

        if(filenamelable.getText().contains("actionClass_Menu")){
            System.out.println("Pass: File selected correctly"  +  filenamelable);
        }else {
            System.out.println("Failed : incorrect file name " + filenamelable);
        }

        WebElement Uploadbutton = driver.findElement(By.id("uploadBtn"));
        Uploadbutton.click();


        WebElement result = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("result"))
        );

        String Expectedmsg = "file 'actionClass_Menu.html' uploded  ";

        if(result.getText().equals(Expectedmsg)){
            System.out.println(
                    "Pass: uploas confarm" + result.getText()
            );
        }else {
            System.out.println("Fail: mismach massage " + result.getText());
        }


        driver.quit();


    }
}