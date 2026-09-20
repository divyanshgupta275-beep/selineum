package Day_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class open_close_multi_broser {
    public static class open_close_multi {

        public static void main(String[] args) {
            WebDriver obj_driver = new ChromeDriver();


            try{
                obj_driver.get("https://shala.com/");
                System.out.println("Page title is: " + obj_driver.getTitle());
                obj_driver.get("https://www.google.com/");
                System.out.println("page title is " + obj_driver.getTitle());

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                obj_driver.quit();
            }

        }
    }
}




