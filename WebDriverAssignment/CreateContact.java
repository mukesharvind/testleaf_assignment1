package WebDriverAssignment;

import java.time.Duration;
import java.util.Currency;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

public static void main(String[] args) throws InterruptedException {
	
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	driver.findElement(By.xpath("//label[contains(text(),'Username')]/following:: input")).sendKeys("DemoCSR");
	driver.findElement(By.xpath("(//label[text()='Password']/following::input)[1]")).sendKeys("crmsfa");
	driver.findElement(By.xpath("//input[@value='Login']")).click();
	driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
	
	
	driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Create Contact')]")).click();
	
	driver.findElement(By.id("firstNameField")).sendKeys("Rajesh");
	driver.findElement(By.id("lastNameField")).sendKeys("Kumar");
	
	driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Krish");
	driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Rakesh");
	
	
	WebElement PreferredCurrency = driver.findElement(By.xpath("//span[contains(text(),'Preferred Currency')]/following:: select"));
	Select currecny = new Select(PreferredCurrency);
	currecny.selectByValue("INR");

	
	WebElement Countrydropdown = driver.findElement(By.id("createContactForm_generalCountryGeoId"));
	Select country = new Select(Countrydropdown);
	country.selectByVisibleText("India");

	WebElement statedropdown = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
	Select state = new Select(statedropdown);
	state.selectByVisibleText("TAMILNADU");

	
	driver.findElement(By.xpath("//input[@value='Create Contact']")).click();
	
	String title = driver.getTitle();
	System.out.println("Title of the webpage is " +title);
	
	driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
	
	driver.findElement(By.id("updateContactForm_description")).sendKeys("Hi Helllo Vanakam");
	Thread.sleep(2000);
	driver.findElement(By.id("updateContactForm_description")).clear();
	
	driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Hi Hello Vanakam");
	driver.findElement(By.xpath("//input[@name='submitButton']")).click();
	
	//Handling pop-ups
	//driver.findElement(By.xpath("//a[contains(text(),'Deactivate Contact')]")).click();
	String title2 = driver.getTitle();
	System.out.println("The title of the webpage is " +title2);
	
Thread.sleep(3000);
driver.close();
}

}
