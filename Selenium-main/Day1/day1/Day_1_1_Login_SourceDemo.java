package Day_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day_1_1_Login_SourceDemo {

    public static void main(String[] args) {

        WebDriver obj_driver = new ChromeDriver();
        try{
            obj_driver.get("https://www.saucedemo.com/");
            Thread.sleep(10000);
            WebElement obj_username = obj_driver.findElement(By.id("user-name"));
            WebElement obj_password = obj_driver.findElement(By.id("password"));
            WebElement obj_loginButton = obj_driver.findElement(By.id("login-button"));

            obj_username.sendKeys("standard_user");
            obj_password.sendKeys("secret_sauce");
            obj_loginButton.click();
            Thread.sleep(10000);

            if(obj_driver.getCurrentUrl().contains("inventory.html")){
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed");
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            obj_driver.quit();

        }
    }

    public static class open_close_multi {

        public static void main(String[] args) {
            WebDriver obj_driver = new ChromeDriver();


            try{
                obj_driver.get("https://www.w3schools.com/");
                obj_driver.get("https://www.google.com/");

                System.out.println("Page title is: " + obj_driver.getTitle());
                System.out.println("page title is" + obj_driver.getTitle());

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                obj_driver.quit();
            }

        }
    }
}
