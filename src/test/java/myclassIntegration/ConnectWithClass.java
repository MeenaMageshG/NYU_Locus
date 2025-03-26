package myclassIntegration;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConnectWithClass extends ProjectSpecifier {
	 @Test
	    public void createusermanagement() throws Throwable {
	        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));  // Updated line
	        wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='menuButton']"))).click();
	        driver.findElement(By.xpath("(//a[@class='router-link-active router-link-exact-active active'])[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("(//button[contains(@class, 'create-search-button')])[1]")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("(//input[contains(@class, 'offering-create')])[1]")).sendKeys("class");
	        WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(20));  
	        wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='academic-term-select']/option[text()='Term2025']"))).click();
	        driver.findElement(By.xpath("//button[contains(@class, 'add-button')]")).click();
	        driver.findElement(By.xpath("//li[@class='fd__item']//a[text()='Mclean Griffith (Griffith29)']")).click();
	        driver.findElement(By.xpath("//input[@type='checkbox' and @value='Tue']")).click();
	        driver.findElement(By.xpath("//input[@type='checkbox' and @value='Wed']")).click();
	        driver.findElement(By.xpath("//input[@type='checkbox' and @value='Thu']")).click();
	        driver.findElement(By.xpath("(//button[@class='red btn-primary'])[1]")).click();
	        Thread.sleep(2000);
	        

}
}