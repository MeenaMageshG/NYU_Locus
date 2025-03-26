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

public class DeveloperLogin {
	
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

}
    @Test
    public void developersettings() throws Throwable {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement colour = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='site_color'])[2]")));
    	colour.click();
    	Thread.sleep(2000);
    	colour.clear();
    	Thread.sleep(2000);
    	colour.sendKeys("#023020");
    	Thread.sleep(2000);
    	WebElement save = driver.findElement(By.xpath("(//span[normalize-space()='Save'])[1]"));
    	save.click();
    	 
         }
    @AfterMethod
    public void tearDown() {
        System.out.println("Closing the browser...");
        if (driver != null) {
            driver.quit();
        }
   
    	}
}
          