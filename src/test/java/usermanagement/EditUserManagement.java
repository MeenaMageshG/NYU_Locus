package usermanagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class EditUserManagement {
    private WebDriver driver;

	@BeforeMethod
    public void setUp() throws Throwable {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars", "--disable-popup-blocking", "incognito");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.get("https://nyu-dev.webwizardsusa.com/admin/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("noreply@locus.online");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void viewusermanagement() throws Throwable {
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='menuButton']"))).click();
        
        driver.findElement(By.xpath("(//p[normalize-space()='User Management'])[1]")).click();
        driver.findElement(By.xpath("(//input[@id='search'])[1]")).sendKeys("nyu@gmail.com");
        driver.findElement(By.xpath("(//button[normalize-space()='Search'])[1]")).click();
        
        WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-original-title='Edit']"))).click();
        
        // Edit the user details
        WebElement edit = driver.findElement(By.xpath("(//input[@id='first_name'])[1]"));
        edit.click();
        edit.sendKeys("er");
        
        WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement updateButton = wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[normalize-space()='Update'])[1]")));
        
        Actions actions = new Actions(driver);
        actions.moveToElement(updateButton).perform();
        updateButton.click();
        driver.navigate().refresh();
        
        driver.findElement(By.xpath("(//input[@id='search'])[1]")).sendKeys("nyu@gmail.com");
        driver.findElement(By.xpath("(//button[normalize-space()='Search'])[1]")).click();
        
    }
    
	@AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}