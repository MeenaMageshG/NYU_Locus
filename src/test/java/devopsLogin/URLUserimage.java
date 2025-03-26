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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class URLUserimage {
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
        WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Amazon S3']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@type='checkbox' and @name='student_image_upload_type'])[2]")).click();
        driver.findElement(By.xpath("(//span[normalize-space()='Save'])[1]")).click();
        driver.quit();
       }
    @Test
    public void createusermanagement() throws Throwable {
    	
    	WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars", "--disable-popup-blocking", "incognito");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://nyu-dev.webwizardsusa.com/admin/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("noreply@locus.online");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));  
        wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='menuButton']"))).click();
        driver.findElement(By.xpath("(//a[@class='router-link-active router-link-exact-active active'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[contains(@class, 'create-search-button')])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//input[contains(@class, 'offering-create')])[1]")).sendKeys("Dev");
        
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement termDropdown = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='academic-term-select']/option[text()='Spring 2024']")));
        termDropdown.click();
        driver.findElement(By.xpath("//button[contains(@class, 'add-button')]")).click();
        driver.findElement(By.xpath("//li[@class='fd__item']//a[text()='Brook harry (87568)']")).click();
        driver.findElement(By.xpath("//input[@type='checkbox' and @value='Tue']")).click();
        driver.findElement(By.xpath("//input[@type='checkbox' and @value='Wed']")).click();
        driver.findElement(By.xpath("//input[@type='checkbox' and @value='Thu']")).click();
        driver.findElement(By.xpath("(//button[@class='red btn-primary'])[1]")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//span[text()='Enroll']")).click();
        driver.findElement(By.xpath("(//input[@id='student_name'])[1]")).sendKeys("a");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[contains(text(),'Alea Yang')])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[contains(text(),'Amos Church')])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[@class='btn-close' and @aria-label='Close'])")).click();
        driver.findElement(By.xpath("(//span[@class='button-text'][normalize-space()='Assign Room'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//select[@id='room-select']/option[text()='New Room']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Change Room']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[text()='Auto Assign'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//li/label[contains(text(), 'Alphabetical by Last Name')])[1]")).click();
         driver.findElement(By.xpath("//button[.//span[text()='Update']]")).click();
         Thread.sleep(2000);
         WebDriverWait menu = new WebDriverWait(driver, Duration.ofSeconds(10));  
         menu.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='menuButton']"))).click();
         driver.findElement(By.xpath("(//p[normalize-space()='User Management'])[1]")).click();
         Thread.sleep(2000);
         WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
         search.click();
         search.sendKeys("testins");
         driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("(//button[@data-original-title='Edit'])[2]")).click();
         Thread.sleep(2000);
         WebElement url = driver.findElement(By.xpath("//input[@placeholder='Enter Photo URL']"));
         url.click();
         url.sendKeys("https://www.freepik.com/free-vector/young-prince-royal-attire_386983822.htm#fromView=keyword&page=1&position=20&uuid=62317751-2fa6-49dd-9692-9b4be2c59ec7&query=Avatar+Placeholder");
         Thread.sleep(2000);
         driver.findElement(By.xpath("//span[normalize-space()='Update']")).click();
         
         
         
}
}
