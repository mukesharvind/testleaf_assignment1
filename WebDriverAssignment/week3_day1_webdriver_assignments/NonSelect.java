package WebDriverAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NonSelect {
public static void main(String[] args) throws InterruptedException {
	
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.leafground.com/select.xhtml");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	WebElement ele = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));	
	
	Select dropdown1 = new Select(ele);
	
	int size = dropdown1.getOptions().size();
	
	for (int i = 0; i < size; i++) {
	
		Thread.sleep(2000);
		
		dropdown1.selectByIndex(i);
	
	}
	
	//dropdown1.selectByVisibleText("Selenium");
	
	driver.findElement(By.xpath("//label[@id='j_idt87:country_label']")).click();
	driver.findElement(By.xpath("//li[contains(text(),'Germany')]")).click();
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//label[contains(text(),'Select City')]")).click();
	driver.findElement(By.xpath("//li[contains(text(),'Berlin')]")).click();

	Thread.sleep(3000);
	

	driver.findElement(By.xpath("//button[@type='button']")).click();
	driver.findElement(By.xpath("//li[contains(text(),'Selenium WebDriver')]")).click();
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//button[@type='button']")).click();
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//li[contains(text(),'Playwright')]")).click();
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//button[@type='button']")).click();
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//li[contains(text(),'RestAssured')]")).click();
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//button[@type='button']")).click();
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//li[contains(text(),'JMeter')]")).click();
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//label[contains(text(),'Select Language')]")).click();
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//li[contains(text(),'Tamil')]")).click();

	Thread.sleep(3000);
	
	driver.findElement(By.id("j_idt87:value_label")).click();
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//li[contains(text(),'à®’à®©à¯?à®±à¯?')]")).click();
	
	Thread.sleep(3000);
	
	driver.close();
	
	
}
}
