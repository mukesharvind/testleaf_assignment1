package week4.day2.webdriver.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//login to the browser
		driver.findElement(By.xpath("(//label[text()='Username']/following::input)[1]")).sendKeys("DemoCSR");
		driver.findElement(By.xpath("(//label[contains(text(),'Password')]/following:: input)[1]")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		
		//click contacts and merge contact
		driver.findElement(By.partialLinkText("Contacts")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Merge')]")).click();
		
		
		
		//get the parent window handle
		String parentwindowHandle = driver.getWindowHandle();
		System.out.println("The parent window is "+parentwindowHandle);
		
		//click the widget
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
			
		//getting the set of windows and iterating with for each loop
				
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
		System.out.println("The wiondows Title are "+string);
				}
		//getting the size of the windows
		int size = windowHandles.size();
		System.out.println("The size of the windows are "+size);

		
		//convert set to list to switch to a particular window
		
		List <String> listofHandles = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(listofHandles.get(1));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		
		//back to parenthandle and clicking the widget
		driver.switchTo().window(parentwindowHandle);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		
		
		//Going to another child handle 
		//getting the set of windows and iterating with for each loop
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		
		//getting the size of the windows
		
		int size1 = windowHandles1.size();
		System.out.println("The size of the windows are "+size1);
		
		
				
		//convert set to list to switch to a particular window
		
		List <String> listofHandles1 = new ArrayList<String>(windowHandles1);
		
		//getting string
		for (String string : listofHandles1) {
			System.out.println("The wiondows Title are "+string);
		}
				
		driver.switchTo().window(listofHandles1.get(1));
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();
		
		//switching to parentwindow
		driver.switchTo().window(parentwindowHandle);
		driver.findElement(By.xpath("//a[(text()='Merge')]")).click();
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();
		driver.close();
		
		
	}

}
