package straitsTimesTest;

import java.io.File;
import java.net.MalformedURLException;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumstraitstimesTest {
    private static AndroidDriver driver;
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/apps");
        File app = new File(appDir, "straitstimes.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        capabilities.setCapability("deviceName", "GalaxyS5");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.straitstimes");
        capabilities.setCapability("appActivity", ".activity.MainTabActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);



        driver.findElement(By.xpath("//button[@class='navbar-toggle collapsed']")).click();
        driver.findElement(By.xpath("//button[@class='navbar-toggle-user']")).click();
        driver.findElement(By.xpath("//li[@class='nav-login']//a[contains(text(),Login)]")).click();

        driver.findElement(By.id("j_username")).clear();
        driver.findElement(By.id("j_username")).sendKeys("digitaltest2");
        driver.findElement(By.id("j_password")).clear();
        driver.findElement(By.id("j_password")).sendKeys("Sphdigital1");
        driver.findElement(By.xpath("//button[@class='btn']")).click();
        //get logged name id
        driver.findElement(By.xpath("//li[@class='nav-login']//a[contains(text(),'taltest2')]")).getText();

        //get the heading title
        driver.findElement(By.xpath("//h1[@class='headline node-title']")).getText();
        //click on article
        driver.findElement(By.xpath("//a[@class='block-link']")).click();

        //driver quit
        driver.quit();
    }
}
