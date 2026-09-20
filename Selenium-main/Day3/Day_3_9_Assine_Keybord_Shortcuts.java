package Day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Day_3_9_Assine_Keybord_Shortcuts {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void navigateMultipleSites() {

        driver.get("https://www.saucedemo.com");
        driver.getTitle();
        Assert.assertEquals( driver.getTitle(),"Swag Labs","Title not match");


        driver.get("https://www.google.com");
        driver.getTitle();
        Assert.assertEquals( driver.getTitle(),"Google","Title not match");


        driver.get("https://www.selenium.dev/");
        driver.getTitle();
        Assert.assertEquals( driver.getTitle(),"Selenium","Title not match");





    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}