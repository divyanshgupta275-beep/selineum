package Day_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Drivinglic_By_Css_Selector {

    public static void main(String[] args) {
        WebDriver Loc_driver = new ChromeDriver();

        try {
            Loc_driver.get("file:///C:/Users/CCST/Desktop/Selanium101/DriverFileGiven/TestcasesClassAssignment-drivingLicenseUI.html");

            Thread.sleep(1000);

            WebElement obj_Fullname =  Loc_driver.findElement(By.cssSelector("input[id = 'fullname']"));
            WebElement obj_Address =  Loc_driver.findElement(By.cssSelector("input[id = 'address']"));
            WebElement obj_Age =  Loc_driver.findElement(By.cssSelector("input[id = 'age']"));
            WebElement obj_Birthplace =  Loc_driver.findElement(By.cssSelector("input[id = 'placeofbirth']"));
            WebElement obj_MaleGender = Loc_driver.findElement(By.cssSelector("input[id = 'Male']"));
//            WebElement obj_FemalGender = Loc_driver.findElement(By.xpath("Female"));
            WebElement obj_IsColourBlind = Loc_driver.findElement(By.cssSelector("input[name = 'color_yes']"));
            WebElement obj_clickSubmit = Loc_driver.findElement(By.cssSelector("button[type = 'submit']"));

            Thread.sleep(1000);

            obj_Fullname.sendKeys("Raj");
            Thread.sleep(1000);
            obj_Address.sendKeys("Satara");
            Thread.sleep(1000);
            obj_Age.sendKeys("56");
            Thread.sleep(1000);
            obj_Birthplace.sendKeys("Pune");
            Thread.sleep(1000);
            obj_MaleGender.click();
            Thread.sleep(1000);
            obj_IsColourBlind.click();
            Thread.sleep(1000);
            obj_clickSubmit.click();
            Thread.sleep(3000);



        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            Loc_driver.quit();
        }
    }

}
