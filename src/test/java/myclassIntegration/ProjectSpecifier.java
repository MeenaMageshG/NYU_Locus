package myclassIntegration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecifier {
	 public WebDriver driver;

	   
		
		@BeforeMethod
	    public void setUp() throws Throwable {
	        WebDriverManager.chromedriver().setup();
	        ChromeOptions chromeOptions = new ChromeOptions();
	        chromeOptions.addArguments("disable-infobars", "--disable-popup-blocking", "incognito");

	        driver = new ChromeDriver(chromeOptions);
	        driver.manage().window().maximize();

	        driver.get("https://nyu-dev.webwizardsusa.com/admin/login");

	        // Updated WebDriverWait with Duration
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("noreply@locus.online");
	        driver.findElement(By.id("password")).sendKeys("password");
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	    }
		
		@AfterMethod
	    public void tearDown() {
	        System.out.println("Closing the browser...");
	        if (driver != null) {
	            driver.quit();
	        }
	    }

}
