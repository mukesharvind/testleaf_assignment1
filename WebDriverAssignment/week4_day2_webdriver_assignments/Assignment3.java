package week4.day2.webdriver.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment3 {

		public static void main(String[] args) throws InterruptedException {
			{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		//hitting the webpage
		driver.get("https://www.nykaa.com/");
	
		//mouseover to Brands and Search L'Oreal Paris action class
		WebElement BrandsHover = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions action = new Actions(driver);
		action.moveToElement(BrandsHover).perform();
		
		WebElement LorealText = driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
		LorealText.sendKeys("L'Oreal Paris");
		
		 Thread.sleep(3000);
		 
		 driver.findElement(By.xpath("(//a[contains(text(),'Oreal Paris')])[1]")).click();
		 
		 
		 //getting title
		 String title = driver.getTitle();
		 System.out.println("The title of the webpage is "+title);
		 
		 //scroll to sortby
		 WebElement scroll = driver.findElement(By.xpath("//span[text()='Sort By : popularity']"));
	        
	     action.scrollToElement(scroll).perform();
	        
	     action.click(scroll).perform();
	     
	     //sort By and select customer top rated
	     WebElement CustomerTopRated = driver.findElement(By.xpath("(//span[text()='customer top rated']/following::div)[1]"));
		action.click(CustomerTopRated).perform();
			
		//scroll to Category and click Hair->Click haircare->Shampoo
			WebElement CategoryScroll = driver.findElement(By.xpath("//span[text()='Category']"));
			action.moveToElement(CategoryScroll).perform();
			action.click(CategoryScroll).perform();
			Thread.sleep(3000);
			WebElement HairClick = driver.findElement(By.xpath("//span[text()='Hair']"));
			action.click(HairClick).perform();
			Thread.sleep(3000);
			WebElement HairCareClick = driver.findElement(By.xpath("//span[text()='Hair Care']"));
			action.click(HairCareClick).perform();
			Thread.sleep(3000);
			WebElement ShampooClick = driver.findElement(By.xpath("//span[text()='Shampoo']"));
			Thread.sleep(3000);
			action.click(ShampooClick).perform();
			
			//>Concern->Color Protection
			
			WebElement ConcernClick = driver.findElement(By.xpath("//span[text()='Concern']"));
			action.moveToElement(ConcernClick).perform();
			action.click(ConcernClick).perform();
			
			WebElement ConcernPortection = driver.findElement(By.xpath("//span[text()='Color Protection']"));
			action.moveToElement(ConcernPortection).perform();
			action.click(ConcernPortection).perform();
			
			//check if filter applied with shampoo
			WebElement shampoofilter = driver.findElement(By.xpath("(//span[text()='Shampoo'])[1]"));
			String Shampoo = shampoofilter.getText();
			System.out.println("The element present in the filter is "+Shampoo);
			
			//get parent window name
			Thread.sleep(5000);
			WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'Paris Colour Protect Shampoo With UVA')]"));
			String Parentwindow = driver.getWindowHandle();
			System.out.println("The Parent window is "+Parentwindow);
			action.scrollToElement(ele).perform();
			Thread.sleep(5000);
			action.click(ele).perform();
			
			
			//iterate with forloop to get list of windows 
			Set<String> windowHandles = driver.getWindowHandles();
			for (String string : windowHandles) {
				System.out.println("The list of windows are "+string);
			}
			List<String>listofwindows = new ArrayList<String>(windowHandles);
			
			//switching to childwindow 
			driver.switchTo().window(listofwindows.get(1));
			String title2 = driver.getTitle();
			System.out.println("The title of the new webpage is "+title2);
			
			//GO to the new window and select size as 175ml
			driver.findElement(By.xpath("//span[text()='180ml']")).click();
			
			//Print the MRP of the product
			String MRP = driver.findElement(By.xpath("(//span[text()='₹209'])[1]")).getText();
			System.out.println("The MRP of the product is "+MRP);
			
			//click add to bag
			driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
			
			//view bag and click proceed after getting grand total
			driver.findElement(By.xpath("(//*[name()='svg']/parent::button)[3]")).click();
			
			Thread.sleep(3000);
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			WebElement grandtotal = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]"));
			action.scrollToElement(grandtotal).perform();
			String text = grandtotal.getText();
			System.out.println("The grand total is "+text);
			Thread.sleep(3000);
			
			//click proceed switching to default content
			driver.findElement(By.xpath("//span[text()='Proceed']")).click();
			driver.switchTo().defaultContent();
			//closing childwindow
			Thread.sleep(3000);
			driver.close();
			
			//closing parent window
			driver.switchTo().window(Parentwindow);
			Thread.sleep(3000);
			driver.close();
			
			}
		 

	}

}
