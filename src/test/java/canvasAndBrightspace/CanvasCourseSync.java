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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CanvasCourseSync {
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
        Actions scroll = new Actions(driver);
        WebElement course = driver.findElement(By.xpath("(//a[normalize-space()='test123'])[1]"));
        scroll.moveToElement(course).perform();
        course.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[normalize-space()='People'])[1]")).click();
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://nyu-dev.webwizardsusa.com/?external_id=20')");
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        String parentWindow = iterator.next();
        String newWindow = iterator.next();
        driver.switchTo().window(newWindow);
        System.out.println("Opened new window with title: " + driver.getTitle());
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='submit' and @value='Authorise']")).click();
        Thread.sleep(5000);
        /*WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        WebElement sourceElement = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='btn-group'])[1]")));
        WebElement targetElement = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Drop here to combine sections']")));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceElement, targetElement).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Add Class Site']")).click();
        WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        WebElement sourceElement1 = wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='btn-group'])[1]")));
        WebElement targetElement1 = wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Drop here to combine sections']")));
        Actions actions1 = new Actions(driver);
        actions1.dragAndDrop(sourceElement1, targetElement1).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Continue']")).click();
        Thread.sleep(2000);
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='academic-term-select'])[1]")));
        Select select = new Select(dropdownElement);
        select.selectByValue("266");
        Thread.sleep(2000);
        WebElement dropdownElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='academic-term-select'])[2]")));
        Select select1 = new Select(dropdownElement1);
        select1.selectByValue("266");*/
        
        js.executeScript("window.open('https://nyu-dev.webwizardsusa.com/admin/login')");
        WebDriverWait login = new WebDriverWait(driver, Duration.ofSeconds(20));  
        login.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("noreply@locus.online");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        WebElement search = driver.findElement(By.xpath("(//input[@id='search'])[1]"));
        search.click();
        search.sendKeys("test123");
        Thread.sleep(2000);
        
        
        
        
        
    }

}
