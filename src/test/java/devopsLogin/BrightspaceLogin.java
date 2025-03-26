package devopsLogin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrightspaceLogin {
	private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Throwable {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars", "--disable-popup-blocking", "incognito");

        driver = new ChromeDriver(chromeOptions);
                
        driver.manage().window().maximize();

        driver.get("https://nyu-dev.webwizardsusa.com/admin/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("devops@locus.online");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Brightspace']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@class='form-check-input' and @type='checkbox'])[5]")).click();
        driver.findElement(By.xpath("(//span[normalize-space()='Save'])[1]")).click();
        driver.quit();

}
    @Test
    public void openNewBrowser() throws Throwable {
    	WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars", "--disable-popup-blocking", "incognito");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    	
    	driver.get("https://nyu-dev.webwizardsusa.com/login");
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//button[normalize-space()='Login Via Brightspace']")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("DevCoPInstructor");
        Thread.sleep(2000);
       driver.findElement(By.xpath("//input[@id='password']")).sendKeys("G1<^F'-Lh\\%L+F");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Log In']")).click();
       }
    @AfterMethod
    public void tearDown() {
        System.out.println("Closing the browser...");
        if (driver != null) {
            driver.quit();
        }
}
}
