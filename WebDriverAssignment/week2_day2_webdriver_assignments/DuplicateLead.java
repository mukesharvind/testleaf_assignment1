package WebDriverAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {
public static void main(String[] args) throws InterruptedException {
	
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoCSR");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
	driver.findElement(By.xpath("//a[contains (text(),'SFA')]")).click();
	
	driver.findElement(By.xpath("(//a[contains (text(),'Lea')])[1]")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
	driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
	driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("mukesh.arvind92@gmail.com");
	driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
	
	Thread.sleep(3000);
	WebElement leadid = driver.findElement(By.xpath("(//a[contains(text(),'14')])[1]"));
	String firstleadiid = leadid.getText();
	System.out.println("The first lead id is" +firstleadiid);
	
	leadid.click();
	driver.findElement(By.xpath("//a[contains(text(),'Duplicate Lead')]")).click();
	
	String title = driver.getTitle();
	
	if (title == "Duplicate Lead") {
		System.out.println("The title is "+title);
		
	}
	
	driver.findElement(By.xpath("//input[@value=\"Create Lead\"]")).click();
	
	WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'Rakesh')]"));
	String capturedname = ele.getText();
	System.out.println("The forename is " +capturedname);
	if ("Rakesh" .equals(capturedname)) {
		System.out.println("Verified");
	}
	
//	driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("12345678");
//	driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
	
	Thread.sleep(3000);
	
	
	driver.close();
	
}
}
