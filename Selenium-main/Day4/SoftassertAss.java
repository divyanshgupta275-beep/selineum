package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert; // Added SoftAssert import

import java.time.Duration;

public class SoftassertAss {

    WebDriver driver;
    WebDriverWait wait;

    By welcomeMessage = By.id("message");
    By enterNameButton = By.id("enterNameBtn");
    By nameInputField = By.id("nameField");

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testWelcomeFormInteractions() {

        SoftAssert softAssert = new SoftAssert();

        driver.get("file:///C:/Users/CCST/Desktop/Selanium101/DriverFileGiven/welcome.html");

        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage));
        softAssert.assertEquals(message.getText(), "Welcom!!", "Welcome not match");

        WebElement textField = driver.findElement(nameInputField);
        softAssert.assertFalse(textField.isEnabled(), "Text  disabled ");

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(enterNameButton));
        button.click();
        wait.until(ExpectedConditions.elementToBeClickable(textField));
        softAssert.assertTrue(textField.isEnabled(), "Text field  enabled ");

        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}