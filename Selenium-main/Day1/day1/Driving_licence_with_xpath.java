package Day_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Driving_licence_with_xpath {

        public static void main(String[] args) {
            WebDriver obj_driver = new ChromeDriver();
            try {

                obj_driver.get("file:///c%3A/Users/ccst/Desktop/webAutomationselinium/web/xyz.html");
                WebElement fullname = obj_driver.findElement(By.xpath("//input[@id='fullname']"));
                fullname.sendKeys("Avinash Kanade");
                Thread.sleep(1000);

                WebElement address = obj_driver.findElement(By.xpath("//input[@id='address']"));
                address.sendKeys("at pune nashik");
                Thread.sleep(1000);

                WebElement age = obj_driver.findElement(By.xpath("//input[@id='age']"));
                age.sendKeys("22");
                Thread.sleep(1000);
                WebElement placeofbirth = obj_driver.findElement(By.xpath("//input[@id='placeofbirth']"));
                placeofbirth.sendKeys("nashik");
                Thread.sleep(1000);


                WebElement gender = obj_driver.findElement(By.xpath("//input[@id='Male']"));
                gender.click();
                Thread.sleep(1000);

                WebElement color = obj_driver.findElement(By.xpath("//input[@name='color_no']"));
                color.click();

                WebElement languages = obj_driver.findElement(By.xpath("//select[@id='languages']"));
                Select TypeSelect = new Select(languages);
                TypeSelect.selectByIndex(2);
                Thread.sleep(1000);




                Thread.sleep(1000);
                WebElement submit = obj_driver.findElement(By.xpath("//button[@type='submit']"));
                submit.click();

            }
            catch (Exception e){
                e.printStackTrace();
            }finally {
                obj_driver.quit();
            }




        }
    }


