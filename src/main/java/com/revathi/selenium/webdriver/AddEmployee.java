/**
 * Add Employee Orange HRM site Webdriver code
 */
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddEmployee {
    public static void main(String[] args) {
        WebDriver driver = null;
        driver = new FirefoxDriver();
        String baseUrl = "http://professional.demo.orangehrmlive.com/symfony/web/index.php/auth/login";

        driver.get(baseUrl);
        driver.findElement(By.id("txtUsername")).clear();
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtPassword")).sendKeys("admin");
        driver.findElement(By.id("btnLogin")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.linkText("PIM")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("Revathi");
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("Ram");
        driver.findElement(By.id("btnSave")).click();
        try{
            Thread.sleep(5000);
           }
        catch(InterruptedException e){
            e.printStackTrace();
            }
        driver.findElement(By.id("welcome")).click();
        driver.findElement(By.linkText("Logout")).click();

        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
           e.printStackTrace();
        }
    }
}