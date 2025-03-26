package settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SystemSettingsTests {
    private WebDriver driver;
    private WebDriverWait wait;
    
    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars", "--disable-popup-blocking", "incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://nyu-dev.webwizardsusa.com/admin/login");
        

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Perform login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("noreply@locus.online");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
        
        @Test
        public void systemsettings() throws Throwable {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement menubutton = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='menuButton']")));
        menubutton.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[@class='mb-0' and text()='Settings']")).click();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement scroll = driver.findElement(By.xpath("//span[text()='User ID']"));
        actions.moveToElement(scroll).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='last_name']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='middle_name']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='pronoun']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[.//span[text()='Save']])[1]"));
        actions.moveToElement(menubutton).perform();
        menubutton.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[text()='My Classes']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[h3[@class='cl-title mb-0' and text()='test']]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//img[@id='my-img-123456789'])[2]")).click();
        try {
        	 WebElement studentInfoDiv = driver.findElement(By.xpath("//div[@class='student-info']"));
        	 List<WebElement> headers = studentInfoDiv.findElements(By.tagName("h5"));
        	 List<String> actualHeaderTexts = headers.stream().map(WebElement::getText).collect(Collectors.toList());
        	  List<String> expectedHeaderTexts = Arrays.asList("Preferred Pronoun", "Middle Name", "User Id");
        	  Assert.assertEquals(actualHeaderTexts, expectedHeaderTexts, "Header texts do not match!");
        	  System.out.println("Verified successfully");
        } catch (AssertionError e) {
            // If assertion fails
            System.out.println("Text missed: " + e.getMessage());
        }
        
    }

  
    }

