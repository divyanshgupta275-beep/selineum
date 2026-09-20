package Day_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class negative_testcase {
    public static void main(String[] args) {

        WebDriver obj_driver = new ChromeDriver();
        try {
            obj_driver.get("https://www.saucedemo.com/");

            WebElement obj_username = obj_driver.findElement(By.id("user-name"));
            WebElement obj_password = obj_driver.findElement(By.id("password"));
            WebElement obj_loginButton = obj_driver.findElement(By.id("login-button"));

            obj_username.sendKeys("saurabh");
            Thread.sleep(2000);
            obj_password.sendKeys("avinash");
            Thread.sleep(2000);
            obj_loginButton.click();


            if (!obj_driver.findElements(By.className("error-button")).isEmpty()) {
                System.out.println("Login failed");
            } else {
                System.out.println("Login successful");
            }
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            obj_driver.quit();

        }
    }
}


