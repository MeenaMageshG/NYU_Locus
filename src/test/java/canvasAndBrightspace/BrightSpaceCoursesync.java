package canvasAndBrightspace;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class BrightSpaceCoursesync {
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
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://nyu-dev.webwizardsusa.com/?external_id=9518')");
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        String parentWindow = iterator.next();
        String newWindow = iterator.next();
        driver.switchTo().window(newWindow);
        System.out.println("Opened new window with title: " + driver.getTitle());
        Thread.sleep(5000);
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='menuButton']"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[text()='Logout']")).click();
		Thread.sleep(5000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.open('https://nyu-dev.webwizardsusa.com/admin/login')");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("noreply@locus.online");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='form-check form-switch form-control-lg']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//h3[normalize-space()='iseek 101'])[1]")).click();
       }
   
    }
