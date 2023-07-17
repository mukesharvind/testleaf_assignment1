package WebDriverAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//login to test leaf
		
		driver.findElement(By.xpath("//label[contains(text(),'Username')]/following:: input")).sendKeys("DemoCSR");
		driver.findElement(By.xpath("(//label[text()='Password']/following::input)[1]")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		//find leads	
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		
		//Find leads using email address
		
		driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
		driver.findElement(By.xpath("(//label[text()='Email Address:']/following::input)[1]")).sendKeys("mukesh.arvind92@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//Delete lead
		WebElement ele1 = driver.findElement(By.partialLinkText("141"));
		Thread.sleep(3000);
		String  text1= driver.findElement(By.xpath("(//a[contains(text(),'141')])[1]")).getText();
		
		System.out.println("The lead name is "+text1);
		ele1.click();
		
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
//		again find by email
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
		driver.findElement(By.xpath("(//label[text()='Email Address:']/following::input)[1]")).sendKeys("mukesh.arvind92@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
//		//Delete lead
		WebElement ele2 = driver.findElement(By.partialLinkText("141"));
		Thread.sleep(3000);
		String  text2= driver.findElement(By.xpath("(//a[contains(text(),'141')])[1]")).getText();
		System.out.println("The lead name is "+text2);
		//ele2.click();
	
//		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		if (text1!=text2) {
			
			System.out.println("The lead record is deleted");
		}
		
		driver.close();
		
		
	}
}
