package DAY2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class heroku {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");


        driver.findElement(By.xpath("//a[@href='/add_remove_elements/']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@onclick ='addElement()']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@onclick ='deleteElement()']")).click();





    }

}