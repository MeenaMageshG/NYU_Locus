package overallFlow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SystemRoom {
	
private WebDriver driver;

   
	
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

    @Test
    public void CreateSystemRoom() throws Throwable {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='menuButton']"))).click();
        driver.findElement(By.xpath("//p[normalize-space()='System Rooms']")).click();
        driver.findElement(By.xpath("//button[text()=' Create New Room ']")).click();
        driver.findElement(By.id("roomName")).sendKeys("TestRoom");
        driver.findElement(By.xpath("//span[normalize-space()='Create']")).click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='New Row']"))).click();
        
        // Select Room and Seat
        driver.findElement(By.xpath("//div[@id='0_0']")).click();
        driver.findElement(By.xpath("//div[@id='69_0']")).click();
        driver.findElement(By.xpath("//button[@id='curvePoint']//span[@class='button-text'][contains(text(),'Select')]")).click();
        driver.findElement(By.xpath("(//div[@id='32_9'])[1]")).click();
        driver.findElement(By.id("seat")).sendKeys("5");
        Thread.sleep(3000);
        WebDriverWait newrow = new WebDriverWait(driver, Duration.ofSeconds(10));
        newrow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Save & New Row']"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='1_10']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='75_11']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("seat")).sendKeys("6");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Save & Exit']")).click();
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Generate Seat Numbers']"))).click();
        driver.findElement(By.xpath("//span[text()='Create']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='Print Blank Chart']")).click();
        Thread.sleep(3000);
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@class='form-select section-select text-truncate']"));
        dropdownElement.click();
        Thread.sleep(3000);
        Select attendanceDropdown = new Select(dropdownElement);
        attendanceDropdown.selectByValue("1");
        dropdownElement.click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@name='check-button']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='pic-container standard'])[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='reserved']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Save']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='pic-container standard'])[4]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='accessible']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Save']")).click();
        Thread.sleep(2000);
        WebDriverWait menu = new WebDriverWait(driver, Duration.ofSeconds(10));
        menu.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='menuButton']"))).click();
        driver.findElement(By.xpath("//p[normalize-space()='System Rooms']")).click();
        

}
}
