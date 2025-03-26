package myclassIntegration;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAcademicTerm extends ProjectSpecifier{
	
	@Test
    public void Create() throws Throwable {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='menuButton']"))).click();
        driver.findElement(By.xpath("(//p[normalize-space()='Academic Terms'])[1]")).click();
        driver.findElement(By.xpath("(//button[normalize-space()='Create New Term'])[1]")).click();
        driver.findElement(By.xpath("(//input[@id='terms'])[1]")).sendKeys("Term2025");
        WebDriverWait startdate = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement starticon = startdate.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='px-3 py-1'])[1]")));
        starticon.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//span[@class='flatpickr-next-month'])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//span[@class='flatpickr-day' and text()='7'])")).click();
        Thread.sleep(3000);
        WebDriverWait icon = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement calender = icon.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='end_date']")));
        calender.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//span[@class='flatpickr-next-month'])[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//span[@class='flatpickr-day' and text()='18'])[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Create']")).click();
        System.out.println("Academic term - Term2025 was created successfully");
        
        
        
    }

}
