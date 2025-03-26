package canvasAndBrightspace;

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

public class MultisectionaModal {
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
        driver.findElement(By.xpath("(//input[@class='form-check-input' and @type='checkbox'])[4]")).click();
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

    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[span[normalize-space()='Login Via Canvas']]"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='pseudonym_session_unique_id']")).sendKeys("user@example.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='pseudonym_session_password']")).sendKeys("EfNb19DGx0Ux");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Log In']")).click();
        Thread.sleep(2000);
        WebElement coursesLink = driver.findElement(By.id("global_nav_courses_link"));
        coursesLink.click();
        Thread.sleep(2000);

}
}
