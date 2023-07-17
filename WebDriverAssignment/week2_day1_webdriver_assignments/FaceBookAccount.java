package WebDriverAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceBookAccount {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://en-gb.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
		
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Ramya");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("krishnan");
		driver.findElement(By.xpath("(//input[@class ='inputtext _58mg _5dba _2ph-'])[3]")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[contains(@id,'password_step_input')]")).sendKeys("abcdefgh123");
		
		WebElement datedropdown = driver.findElement(By.xpath("//select[contains(@id,'day')]"));
		Select date = new Select(datedropdown);
		date.selectByVisibleText("10");
		
		WebElement monthdropdown = driver.findElement(By.id("month"));
		Select month = new Select(monthdropdown);
		month.selectByIndex(4);
		
		
		WebElement yeardropdown = driver.findElement(By.id("year"));			
		Select year = new Select(yeardropdown);
		year.selectByValue("2021");
	
		driver.findElement(By.xpath("//input[@value='1']")).click();		
		
		Thread.sleep(3000);
		driver.close();
		
	}
}
