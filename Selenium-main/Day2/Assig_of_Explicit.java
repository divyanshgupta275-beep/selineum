package DAY2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class Assig_of_Explicit {
    public static void main(String[] args) {
        WebDriver Loc_driver = new ChromeDriver();

        try {
            Loc_driver.get("file:///C:/Users/ccst/Desktop/SELENIUM/SeleniumMaterial/TestcasesClassAssignment-drivingLicenseUI.html");

            WebDriverWait obj_wait = new WebDriverWait(Loc_driver, Duration.ofSeconds(10));
            String parenthandel = Loc_driver.getWindowHandle();

            WebElement obj_Fullname = Loc_driver.findElement(By.cssSelector("input[id='fullname']"));
            WebElement obj_Address = Loc_driver.findElement(By.cssSelector("input[id='address']"));
            WebElement obj_Age = Loc_driver.findElement(By.cssSelector("input[id='age']"));
            WebElement obj_Birthplace = Loc_driver.findElement(By.cssSelector("input[id='placeofbirth']"));
            WebElement obj_MaleGender = Loc_driver.findElement(By.cssSelector("input[id='Male']"));
            WebElement obj_IsColourBlind = Loc_driver.findElement(By.cssSelector("input[name='color_yes']"));
            WebElement obj_clickSubmit = Loc_driver.findElement(By.cssSelector("button[type='submit']"));

            obj_Fullname.sendKeys("Avinash");
            obj_Address.sendKeys("Nashik");
            obj_Age.sendKeys("22");
            obj_Birthplace.sendKeys("Pune");
            obj_MaleGender.click();
            obj_IsColourBlind.click();

            obj_clickSubmit.click();

            obj_wait.until(ExpectedConditions.numberOfWindowsToBe(2));

            Set<String> allWindows = Loc_driver.getWindowHandles();
            for (String windowhandel : allWindows) {
                if (!windowhandel.equals(parenthandel)) {
                    Loc_driver.switchTo().window(windowhandel);
                    System.out.println("windows handel dec " + windowhandel);
                    break;
                }
            }

            String actulUrl = Loc_driver.getCurrentUrl();

            if (actulUrl.contains("welcome.html")) {
                System.out.println("PASS : URL Verified" + actulUrl);
            } else {
                System.out.println("FAILED : URL Mismatch" + actulUrl);
            }

            System.out.println(Loc_driver.getTitle());

            WebElement vi = Loc_driver.findElement(By.xpath("//input[@id='nameField' and @disabled]"));
            if (!vi.isEnabled()) {
                System.out.println("Test case pass For Disable Text Box");
            } else {
                System.out.println("TestCase Failed (If Enable)For Disable Text Box");
            }

            WebElement Entername = Loc_driver.findElement(By.id("enterNameBtn"));
            Entername.click();

            WebElement vi2 = Loc_driver.findElement(By.id("nameField"));
            obj_wait.until(ExpectedConditions.elementToBeClickable(vi2));

            if (vi2.isEnabled()) {
                vi2.sendKeys("Avinash");
                System.out.println("Test case pass For Enable Text Box");
            } else {
                System.out.println("TestCase Failed (If Disable)");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Loc_driver.quit();
        }
    }
}
