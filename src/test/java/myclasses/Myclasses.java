package myclasses;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myclasses {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Throwable {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars", "--disable-popup-blocking", "incognito");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.get("https://nyu-dev.webwizardsusa.com/admin/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Updated line
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("noreply@locus.online");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void createusermanagement() throws Throwable {
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));  // Updated line
        wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='menuButton']"))).click();
        driver.findElement(By.xpath("(//a[@class='router-link-active router-link-exact-active active'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[contains(@class, 'create-search-button')])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//input[contains(@class, 'offering-create')])[1]")).sendKeys("MG");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement termDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='academic-term-select']/option[text()='Winter 2023']")));
        termDropdown.click();
        
        driver.findElement(By.xpath("//button[contains(@class, 'add-button')]")).click();
        driver.findElement(By.xpath("//li[@class='fd__item']//a[text()='Mclean Griffith (Griffith29)']")).click();
        driver.findElement(By.xpath("//input[@type='checkbox' and @value='Tue']")).click();
        driver.findElement(By.xpath("//input[@type='checkbox' and @value='Wed']")).click();
        driver.findElement(By.xpath("//input[@type='checkbox' and @value='Thu']")).click();
        driver.findElement(By.xpath("(//button[@class='red btn-primary'])[1]")).click();
        Thread.sleep(3000);
       
        driver.findElement(By.xpath("(//span[text()='Enroll'])[1]")).click();
        driver.findElement(By.xpath("(//input[@id='student_name'])[1]")).sendKeys("t");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[contains(text(),'Test testins')])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[contains(text(),'testact1 Dawson')])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[@class='btn-close' and @aria-label='Close'])")).click();
        driver.findElement(By.xpath("(//span[@class='button-text'][normalize-space()='Assign Room'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//select[@id='room-select']/option[text()='New Room']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Change Room']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='button-text' and normalize-space()='Edit Room']")).click();
        Thread.sleep(4000);
        WebElement number = driver.findElement(By.xpath("//input[@id='seat']"));
        number.click();
        number.clear();
        number.sendKeys("2");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Save & Exit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Continue Seating']")).click();
        /*WebElement uploadButton = driver.findElement(By.xpath("//button[@id='uploadPhoto']"));
        try {
            uploadButton.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", uploadButton);
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[span[text()='Upload Photo']]")).click();
        Thread.sleep(2000);
        String filePath = "/home/sumanas/Pictures/Screenshots/Screenshot from 2025-02-26 19-06-40.png";  
        StringSelection file = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(1000);
        // Press Enter to click on the uploaded image
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        // Move focus to "Select" button using Tab
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(1000);
        // Press Enter to click on "Select"
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Wait for confirmation
        Thread.sleep(2000);
        System.out.println("File uploaded, clicked on image, and selected successfully!");

    } */
    
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[text()='Auto Assign'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//li/label[contains(text(), 'Alphabetical by Last Name')])[1]")).click();
         driver.findElement(By.xpath("//button[.//span[text()='Update']]")).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("(//span[text()='Attendance'])[1]")).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("(//button[text()='Present'])[2]")).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("(//button[text()='Present'])[3]")).click();
         
         
         
    }
    @AfterMethod
    public void tearDown() {
        System.out.println("Closing the browser...");
        if (driver != null) {
            driver.quit();
        }
    } 
}