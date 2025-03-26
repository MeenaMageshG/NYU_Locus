package myclassIntegration;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CreateSystemRoom extends ProjectSpecifier{
	
	@Test
    public void Create() throws Throwable {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='menuButton']"))).click();
        driver.findElement(By.xpath("//p[normalize-space()='System Rooms']")).click();
        driver.findElement(By.xpath("//button[text()=' Create New Room ']")).click();
        driver.findElement(By.id("roomName")).sendKeys("TEST001");
        driver.findElement(By.xpath("//span[normalize-space()='Create']")).click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='New Row']"))).click();
        
        // Select Room and Seat
        driver.findElement(By.xpath("//div[@id='0_0']")).click();
        driver.findElement(By.xpath("//div[@id='69_0']")).click();
        driver.findElement(By.xpath("//button[@id='curvePoint']//span[@class='button-text'][contains(text(),'Select')]")).click();
        driver.findElement(By.xpath("(//div[@id='32_9'])[1]")).click();
        driver.findElement(By.id("seat")).sendKeys("5");
        driver.findElement(By.xpath("//span[text()='Save & Exit']")).click();

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Generate Seat Numbers']"))).click();
        driver.findElement(By.xpath("//span[text()='Create']")).click();
        Thread.sleep(3000);
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@class='form-select section-select text-truncate']"));
        dropdownElement.click();
        Thread.sleep(3000);
        Select attendanceDropdown = new Select(dropdownElement);
        attendanceDropdown.selectByValue("1");
        dropdownElement.click();
        Thread.sleep(2000);
        WebDriverWait verify = new WebDriverWait(driver, Duration.ofSeconds(10));
        verify.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='menuButton']"))).click();
        driver.findElement(By.xpath("//p[normalize-space()='System Rooms']")).click();
        Thread.sleep(2000);
        
    }

}
