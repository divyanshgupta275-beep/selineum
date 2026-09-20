package Day_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Driving_Licences {

    public static void main(String[] args) {
        WebDriver obj_driver = new ChromeDriver();
    try {

        obj_driver.get("file:///c%3A/Users/ccst/Desktop/webAutomationselinium/web/xyz.html");

        WebElement obj_licensetype = obj_driver.findElement(By.id("licenseType"));


        Select licenseTypeSelect = new Select(obj_licensetype);
        licenseTypeSelect.selectByVisibleText("Permanent");
        Thread.sleep(1000);
        WebElement fullname = obj_driver.findElement(By.id("fullname"));
        fullname.sendKeys("Avinash Kanade");
        Thread.sleep(1000);

        WebElement address = obj_driver.findElement(By.id("address"));
        address.sendKeys("pune");
        Thread.sleep(1000);
        WebElement age = obj_driver.findElement(By.id("age"));

        age.sendKeys("22");
        Thread.sleep(1000);
        WebElement placeofbirth = obj_driver.findElement(By.id("placeofbirth"));
        placeofbirth.sendKeys("nashik");
        Thread.sleep(1000);


        WebElement gender = obj_driver.findElement(By.id("Male"));
        gender.click();
        Thread.sleep(1000);

        WebElement color = obj_driver.findElement(By.name("color_no"));
        color.click();

        WebElement languages = obj_driver.findElement(By.id("languages"));


        Select TypeSelect = new Select(languages);
         TypeSelect.selectByIndex(1);
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
