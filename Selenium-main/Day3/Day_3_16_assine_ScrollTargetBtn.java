package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day_3_16_assine_ScrollTargetBtn {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            driver.get("file:///C:/Users/ccst/Desktop/SELENIUM/SeleniumMaterial/hiddenElementJavascriptExecutor.html");

            Thread.sleep(1000);

            WebElement hiddenbutton = driver.findElement(By.id("hiddenBtn"));

            Thread.sleep(2000);

            js.executeScript("arguments[0].scrollIntoView(true);", hiddenbutton);

            Thread.sleep(2000);

            try {
                hiddenbutton.click();
                System.out.println("click() succeeded");
            } catch (Exception e) {
                System.out.println("Click() failed: " + e.getClass().getSimpleName());


                js.executeScript("arguments[0].click();", hiddenbutton);


                String hiddentext = (String) js.executeScript("return arguments[0].textContent;", hiddenbutton);
                System.out.println("Hidden Button Text : " + hiddentext);

                Thread.sleep(2000);

                String result = driver.findElement(By.id("result")).getText();

                if (result.equals("Hey Your Treasure will be at your doorstep, wait until TOMORROW !")) {
                    System.out.println("Result text is Pass ");
                } else {
                    System.out.println("Result element is Fail");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //driver.quit();
        }

        /*
         *
         *
         *
         * */
    }
}