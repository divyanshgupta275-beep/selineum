package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WelcomeAssets {
    WebDriver driver;
    WebDriverWait wait;


    By welcomeMessage = By.id("message");
    By enterNameButton = By.id("enterNameBtn");
    By nameInputField = By.id("nameField");

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testWelcomeFormInteractions() {
        driver.get("file:///C:/Users/CCST/Desktop/Selanium101/DriverFileGiven/welcome.html");


        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage));
        Assert.assertEquals(driver.getTitle(), "Welcome!!");

        WebElement textField = driver.findElement(nameInputField);
        Assert.assertFalse(textField.isEnabled(), "Desible Fild");

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(enterNameButton));
        button.click();
        wait.until(ExpectedConditions.elementToBeClickable(textField));
        Assert.assertTrue(textField.isEnabled(), "Text field  enabled ");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}