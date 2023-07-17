package WebDriverAssignment;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreatLeadAssignment1 {
	public static void main(String[] args) throws InterruptedException  {
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/login");
	driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoCSR");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
	driver.findElement(By.xpath("//a[contains (text(),'SFA')]")).click();
	
	driver.findElement(By.xpath("(//a[contains (text(),'Lea')])[1]")).click();
	driver.findElement(By.xpath("(//a[contains (text(),'Create Lead')])[1]")).click();
	
	//driver.findElement(By.xpath("(//span[text()='Company Name']/following::input)[1]"));
	driver.findElement(By.xpath("(//input[contains(@name,'companyName')])[2]")).sendKeys("NTT");
	driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Rakesh");
	//driver.findElement(By.xpath("(//span[contains(text(),'Foren')]/following::input)[1]")).sendKeys("Rakesh");
	//driver.manage().timeouts().implicitlyWait(30);
	//(//span[contains(text(),'Forename')]/following::input)[1]
	//driver.findElement(By.xpath("(//span[contains(text(),'Surname')]/following::input)[1]")).sendKeys("Moorthy");
	driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Moorthy");
	
	driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Mike");
	driver.findElement(By.xpath("//input[@id='createLeadForm_lastNameLocal']")).sendKeys("Ruth");
	
	driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys("Software Engineering");
	driver.findElement(By.xpath("//textarea[@id='createLeadForm_description']")).sendKeys("XXXXYYYYY");
	
	driver.findElement(By.xpath("(//span[contains(text(),'E-Mail Address')]/following::input)[1]")).sendKeys("mukesh.arvind92@gmail.com");
	
	WebElement state = driver.findElement(By.xpath("(//span[contains(text(),'State')]/following::select)[1]"));
	
	Select stateprovince = new Select(state);
	Thread.sleep(3000);
	stateprovince.selectByVisibleText("New York");
	String title = driver.getTitle();
	System.out.println("The title of the webpage is "+title);

	
	//driver.findElement(By.name("//input[@name='submitButton']")).click();
	driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
	
	//Scenario 3 click Fill ImportantNote Field with Any text
	driver.findElement(By.xpath("//a[text()='Edit']")).click();
	driver.findElement(By.id("updateLeadForm_description")).clear();
	driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Hello world");
	driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
	String title2 = driver.getTitle();
	System.out.println("The title of the webpage is "+title2);
	Thread.sleep(3000);
	
	//scenario 3 click duplicate button
	
	String title3 = driver.getTitle();
	System.out.println("The title of the webpage is " +title3);
	
	driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
	driver.findElement(By.xpath("(//input[@class='inputBox'])[1]")).clear();
	driver.findElement(By.xpath("(//span[contains(text(),'Company Name')]/following::input)[1]")).sendKeys("CGI");

	driver.findElement(By.xpath("//input[@name='firstNameLocal']")).clear();
	driver.findElement(By.xpath("(//span[contains(text(),'First Name (Local)')]/following::input)[1]")).sendKeys("Ram");
	driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
	

	
	driver.close();
	
	
	}

}
