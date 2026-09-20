package DAY2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationWindow {
    public static void main(String[] args) {
        WebDriver obj_driver = new ChromeDriver();
        try{
            Thread.sleep(2000);
            obj_driver.manage().window().maximize();
            obj_driver.get("https://www.google.com/");
            System.out.println("step 1 loaded via get() " + obj_driver.getTitle());
            System.out.println("handle after get() " + obj_driver.getWindowHandle());


            obj_driver.navigate().to("https://www.selenium.dev/");
            System.out.println("step 2 loaded via navigate().to " + obj_driver.getTitle());
            System.out.println("handle after navigate().to " + obj_driver.getWindowHandle());



            obj_driver.navigate().to("https://www.wikipedia.org/");
            System.out.println("step 3 loaded via navigate().to " + obj_driver.getTitle());
            System.out.println("handle after navigate().to " + obj_driver.getWindowHandle());


            obj_driver.navigate().back();
            System.out.println("step 4 loaded via navigate().back() " + obj_driver.getTitle());
            Thread.sleep(2000);


            obj_driver.navigate().forward();
            System.out.println("step 5 loaded via navigate().forward() " + obj_driver.getTitle());
            Thread.sleep(2000);

            obj_driver.navigate().refresh();
            System.out.println("step 6 loaded via navigate().refresh() " + obj_driver.getTitle());
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            obj_driver.quit();
        }
    }
}
