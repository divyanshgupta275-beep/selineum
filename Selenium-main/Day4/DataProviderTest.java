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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DataProviderTest {
    WebDriver driver;
    WebDriverWait wait;


    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage = By.xpath("//h3[@data-test='error']");

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @DataProvider(name = "loginDataset")
    public Object[][] getLoginData() throws IOException {
        String csvFilePath = "C:\\Users\\CCST\\Desktop\\Selanium101\\DriverFileGiven\\loginData.csv";
        List<Object[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] values = line.split(",", -1);
                String username = values.length > 0 ? values[0].trim() : "";
                String password = values.length > 1 ? values[1].trim() : "";
                records.add(new Object[]{username, password});
            }
        }
        return records.toArray(new Object[0][0]);
    }

    @Test(dataProvider = "loginDataset")
    public void testPositiveLoginSauceDemo(String username, String password) {
        driver.get("https://www.saucedemo.com/");

        WebElement userElem = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        WebElement passElem = driver.findElement(passwordField);
        WebElement loginBtn = driver.findElement(loginButton);

        userElem.sendKeys(username);
        passElem.sendKeys(password);
        loginBtn.click();

        wait.until(ExpectedConditions.urlContains("inventory.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Login Failed.");
    }

    @Test(groups = {"regression"})
    public void testNegativeLoginSauceDemo() {
        driver.get("https://www.saucedemo.com/");

        WebElement userElem = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        WebElement passElem = driver.findElement(passwordField);
        WebElement loginBtn = driver.findElement(loginButton);

        userElem.sendKeys("invalid_user");
        passElem.sendKeys("invalid_password");
        loginBtn.click();

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}