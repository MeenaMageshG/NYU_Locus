package myclassIntegration;

import org.testng.annotations.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateUmanagement extends ProjectSpecifier {
	 @Test
	    public void createusermanagement() throws Throwable {
	        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='menuButton']"))).click();
	        
	        // Navigate to User Management
	        driver.findElement(By.xpath("(//p[normalize-space()='User Management'])[1]")).click();
	        
	        // Click 'Create New User' button
	        driver.findElement(By.xpath("(//button[normalize-space()='Create New User'])[1]")).click();
	        
	        // Fill out the user creation form
	        driver.findElement(By.id("first_name")).sendKeys("Test2025");
	        driver.findElement(By.id("middle_name")).sendKeys("1001");
	        driver.findElement(By.id("last_name")).sendKeys("02");
	        driver.findElement(By.id("pronoun")).sendKeys("HER");
	        driver.findElement(By.id("userid")).sendKeys("NYU0001");
	        driver.findElement(By.id("email")).sendKeys("nyu@gmail.com");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//select[@id='role']/option[@value='3']")).click();
	     // Scroll Down to ensure all elements are visible
	        Robot robot = new Robot();
	        robot.delay(1000);
	        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	        System.out.println("Page scrolled down.");
	        
	        // Click 'Create' button to submit the form
	        driver.findElement(By.xpath("(//span[normalize-space()='Create'])[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("(//input[@id='search'])[1]")).sendKeys("nyu@gmail.com");
	        driver.findElement(By.xpath("(//button[normalize-space()='Search'])[1]")).click();
	        Thread.sleep(2000);
	        WebElement verify = driver.findElement(By.xpath("//td[@class='direction-left']"));
	        verify.getText();
	        System.out.println(verify);
	        
	    }

}
