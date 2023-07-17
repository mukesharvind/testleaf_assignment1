package WebDriverAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {
public static void main(String[] args) throws InterruptedException {
	
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/main");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	
	driver.findElement(By.xpath("//label[contains(text(),'Username')]/following:: input")).sendKeys("DemoCSR");
	driver.findElement(By.xpath("(//label[text()='Password']/following::input)[1]")).sendKeys("crmsfa");
	driver.findElement(By.xpath("//input[@value='Login']")).click();
	driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();

	driver.findElement(By.xpath("(//a[contains(text(),'Leads')])[1]")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
	driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("rakesh");
	driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
	
	Thread.sleep(3000);
	
	WebElement firstleadid = driver.findElement(By.xpath("//a[contains(text(),'14008')]"));
	String leadid = firstleadid.getText();
	System.out.println("The first leadid is " +leadid);
	
	String title = driver.getTitle();
	System.out.println("The title of the webpage is "+title);
	
	Thread.sleep(3000);
	
	driver.close();
	
}
}
