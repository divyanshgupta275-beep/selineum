package DAY2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;


public class DrivingLicWindowHandle {

    public static void main(String[] args) {
        WebDriver Loc_driver = new ChromeDriver();

        try {
            Loc_driver.get("file:///C:/Users/ccst/Desktop/SELENIUM/SeleniumMaterial/TestcasesClassAssignment-drivingLicenseUI.html");

            // Parent handel

            String parenthandel = Loc_driver.getWindowHandle();


            Thread.sleep(1000);

            WebElement obj_Fullname =  Loc_driver.findElement(By.cssSelector("input[id = 'fullname']"));
            WebElement obj_Address =  Loc_driver.findElement(By.cssSelector("input[id = 'address']"));
            WebElement obj_Age =  Loc_driver.findElement(By.cssSelector("input[id = 'age']"));
            WebElement obj_Birthplace =  Loc_driver.findElement(By.cssSelector("input[id = 'placeofbirth']"));
            WebElement obj_MaleGender = Loc_driver.findElement(By.cssSelector("input[id = 'Male']"));
//          WebElement obj_FemalGender = Loc_driver.findElement(By.xpath("Female"));
            WebElement obj_IsColourBlind = Loc_driver.findElement(By.cssSelector("input[name = 'color_yes']"));
            WebElement obj_clickSubmit = Loc_driver.findElement(By.cssSelector("button[type = 'submit']"));

            Thread.sleep(1000);

            obj_Fullname.sendKeys("Saurabh");
            Thread.sleep(1000);
            obj_Address.sendKeys("Chandrapur");
            Thread.sleep(1000);
            obj_Age.sendKeys("31");
            Thread.sleep(1000);
            obj_Birthplace.sendKeys("chandrapur");
            Thread.sleep(1000);
            obj_MaleGender.click();
            Thread.sleep(1000);
            obj_IsColourBlind.click();
            Thread.sleep(1000);
            obj_clickSubmit.click();
            Thread.sleep(3000);

            // get windi=ows handels
            Set<String> allWindows = Loc_driver.getWindowHandles();


            for (String windowhandel : allWindows){
                System.out.println("windows handel dec "+ windowhandel);

                if (!windowhandel.equals(parenthandel)){
                    Loc_driver.switchTo().window(windowhandel);
                    String NewWindow = Loc_driver.getWindowHandle();
                    System.out.println("windows handel dec "+ windowhandel);
                    break;
                }
            }



            String actulUrl = Loc_driver.getCurrentUrl();

            if (actulUrl.contains("welcome.html")){
                System.out.println("PASS : URL Verified" + actulUrl);
            }else {
                System.out.println("FAILED : URL Missmatch" + actulUrl);
            }

            System.out.println(Loc_driver.getTitle());

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            Loc_driver.quit();
        }
    }
}
