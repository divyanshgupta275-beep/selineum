package Project101;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class ProjectSele {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
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
                break;
            }
        }
        return records.toArray(new Object[0][0]);
    }

    @Test(priority = 1,dataProvider = "loginDataset")
    public void loginValid(String username ,String password) {
        By usernameInput = By.id("user-name");
        By passwordInput = By.id("password");
        By loginButton = By.id("login-button");

        driver.findElement(usernameInput).sendKeys(username);

        driver.findElement(passwordInput).sendKeys(password);

        driver.findElement(loginButton).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test(priority = 2)
    public void addAndCheckcart() {


        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
// 3 item takle
        WebElement addedToCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        String cartCount = driver.findElement(By.className("shopping_cart_badge")).getText();

        Assert.assertTrue(addedToCart.isDisplayed());
        Assert.assertEquals(cartCount, "3");
    }

    @Test(priority = 3)
    public void removeOneItem() {


        WebElement removeItem = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removeItem.click();
        System.out.println("Item is removed from cart");
//ata 2 baki ahe
        String updatedCartCount = driver.findElement(By.className("shopping_cart_badge")).getText();

        Assert.assertEquals(updatedCartCount, "2");
    }

    @Test(priority = 4)
    public void CheckoutCart() {

        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Nakul");
        driver.findElement(By.id("last-name")).sendKeys("Kapre");
        driver.findElement(By.id("postal-code")).sendKeys("10235");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();

        WebElement completeHeader = driver.findElement(By.className("complete-header"));
        Assert.assertEquals(completeHeader.getText(), "Thank you for your order!");

        driver.findElement(By.id("back-to-products")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test(priority = 5)
    public void checkFilter() {

        WebElement selectFilter = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(selectFilter);

        select.selectByValue("lohi");

        WebElement firstProduct = driver.findElement(By.className("inventory_item_name"));

        if (firstProduct.getText().equals("Sauce Labs Onesie")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        Assert.assertEquals(firstProduct.getText(), "Sauce Labs Onesie");
    }

    @Test(priority = 6)
    public void Logout() {

        driver.findElement(By.id("react-burger-menu-btn")).click();

        driver.findElement(By.id("logout_sidebar_link")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed());
    }

    @AfterClass
    public void Quittab() {
        if (driver != null) {
            driver.quit();
        }
    }
}