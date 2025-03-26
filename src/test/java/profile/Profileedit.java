package profile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Profileedit {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Throwable {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars", "--disable-popup-blocking", "incognito");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.get("https://nyu.webwizardsusa.com/admin/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("noreply@locus.online");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void createusermanagement() throws Throwable {
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));  
        wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='menuButton']"))).click();
        driver.findElement(By.xpath("//p[@class='mb-0' and text()='Profile']")).click();
        Thread.sleep(2000);
        WebElement fname  = driver.findElement(By.xpath("(//input[@id='First Name'])[1]"));
        fname.clear();
        fname.sendKeys("Test");
        WebElement mname = driver.findElement(By.xpath("(//input[@id='Middle Name'])[1]"));
        mname.clear();
        mname.sendKeys("Profile");
        WebElement lname = driver.findElement(By.xpath("(//input[@id='Last Name'])[1]"));
        lname.clear();
        lname.sendKeys("ABCD");
        Thread.sleep(2000);
        Actions saveelement = new Actions(driver);
        WebElement save = driver.findElement(By.xpath("(//button[@class='btn btn-primary btn-lg'])[1]"));
        saveelement.moveToElement(save);
        save.click();
        
    }
}