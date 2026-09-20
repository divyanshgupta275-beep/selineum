package DAY2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class welcomeExplicitWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            // navigate to local welcome page (update path if needed)
            driver.get("file:///c%3A/Users/ccst/Desktop/webAutomationselinium/web/welcome.html");

            // total timeout for finding elements
            int totalTimeoutSec = 10;

            // candidate locators for name input (fallbacks)
            List<By> nameLocators = Arrays.asList(
                    By.id("name"),
                    By.name("name"),
                    By.id("fullname"),
                    By.name("fullname"),
                    By.cssSelector("input[type='text']"),
                    By.xpath("//input[contains(translate(@id,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'name') or contains(translate(@name,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'name')]")
            );

            // candidate locators for enter button (fallbacks)
            List<By> enterLocators = Arrays.asList(
                    By.id("enterBtn"),
                    By.id("enter"),
                    By.xpath("//button[text()='Enter']"),
                    By.xpath("//button[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'enter')]")
            );

            WebElement nameInput = waitForVisibleElement(driver, totalTimeoutSec, nameLocators);
            nameInput.clear();
            nameInput.sendKeys("Avinash Kanade");
            System.out.println("Name entered: " + nameInput.getAttribute("value"));

            WebElement enterBtn = waitForClickableElement(driver, totalTimeoutSec, enterLocators);
            System.out.println("Enter button is clickable; clicking now.");
            enterBtn.click();

            // optional: wait a short moment for post-click changes
            Thread.sleep(1000);
            System.out.println("Action completed. If the page navigates, verify next steps manually or add post-click checks.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static WebElement waitForVisibleElement(WebDriver driver, int timeoutSec, List<By> locators) throws InterruptedException {
        long end = System.currentTimeMillis() + Duration.ofSeconds(timeoutSec).toMillis();
        while (System.currentTimeMillis() < end) {
            for (By loc : locators) {
                List<WebElement> elems = driver.findElements(loc);
                for (WebElement e : elems) {
                    try {
                        if (e.isDisplayed()) {
                            return e;
                        }
                    } catch (Exception ignored) {}
                }
            }
            Thread.sleep(300);
        }
        throw new org.openqa.selenium.TimeoutException("Timed out waiting for visible element. Tried locators: " + locators);
    }

    private static WebElement waitForClickableElement(WebDriver driver, int timeoutSec, List<By> locators) throws InterruptedException {
        long end = System.currentTimeMillis() + Duration.ofSeconds(timeoutSec).toMillis();
        while (System.currentTimeMillis() < end) {
            for (By loc : locators) {
                List<WebElement> elems = driver.findElements(loc);
                for (WebElement e : elems) {
                    try {
                        if (e.isDisplayed() && e.isEnabled()) {
                            return e;
                        }
                    } catch (Exception ignored) {}
                }
            }
            Thread.sleep(300);
        }
        throw new org.openqa.selenium.TimeoutException("Timed out waiting for clickable element. Tried locators: " + locators);
    }
}
