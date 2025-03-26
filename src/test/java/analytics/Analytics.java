package analytics;

import java.io.File;
import java.time.Duration;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Analytics {
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("noreply@locus.online");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void createusermanagement() throws Throwable {
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='menuButton']"))).click();
        driver.findElement(By.xpath("(//p[normalize-space()='Analytics'])[1]")).click();
        Thread.sleep(2000);
        WebElement studentsCountElement = driver.findElement(By.xpath("//p[@class='card-text' and text()='704']"));
        String studentsCount = studentsCountElement.getText().trim(); // Expected: "704"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='menuButton']"))).click();
        driver.findElement(By.xpath("//p[@class='mb-0' and text()='User Management']")).click();
        driver.findElement(By.xpath("//span[text()='Role Type']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='checkbox' and @id='2']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Role Type']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        WebElement paginationElement = driver.findElement(By.xpath("//div[@class='pagination__items-index']"));
        String paginationText = paginationElement.getText().trim(); // Example: "1–10 of 704"
     // Extract the last numeric part (total students count)
        String totalStudents = paginationText.replaceAll("[^0-9]", ""); // Extracts digits -> "110704"
        totalStudents = totalStudents.substring(totalStudents.length() - 3); // Get last three digits (Total count)

        // Compare and print verification result
        if (studentsCount.equals(totalStudents)) {
            System.out.println("Student count verified: " + studentsCount);
        } else {
            System.out.println("Invalid data! Expected: " + studentsCount + ", Found: " + totalStudents);
        }

        // Assertion for validation
        Assert.assertEquals(studentsCount, totalStudents, "Student count does not match!");
        Thread.sleep(2000);
        
        
    } 
        
  }
