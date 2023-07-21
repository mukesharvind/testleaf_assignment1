package week4.day2.webdriver.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.utils.FileUtil;

public class Assignment5 {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		//launching the website
				driver.get("https://www.amazon.in/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
				//search as oneplus 9 pro
				driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
				driver.findElement(By.id("nav-search-submit-button")).click();
	 
				//Get the price of the first product
				String PhonePrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
				System.out.println("The price of the first displayed phone is "+PhonePrice);
				
				//Print the number of customer ratings for the first displayed product
				String CustomerRating = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
				System.out.println("The total number of customer rating for the displayed phone is " +CustomerRating);				
				
				Actions action = new Actions(driver);
				WebElement hoverelement = driver.findElement(By.xpath("(//a[@role='button']/i)[2]"));
				action.click(hoverelement).perform();
				Thread.sleep(10000);
				
				
				WebElement popupele = driver.findElement(By.xpath("//span[contains(text(),'out of 5')]"));
				action.moveToElement(popupele).perform();
				Thread.sleep(50000);
				//action.click(popupele).perform();
				String text = popupele.getText();
				System.out.println(text);
				
				//Click the first text link of the first image
				String ParentWindowHandle = driver.getWindowHandle();
				System.out.println("The parent Windowhandle is "+ParentWindowHandle);
				
				driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
				Set<String> childwindowhandles = driver.getWindowHandles();
				for (String string : childwindowhandles) {
					System.out.println("The windows opened are "+childwindowhandles);;
				}
				List<String>lisofwindowhandles = new ArrayList<String>(childwindowhandles);
				driver.switchTo().window(lisofwindowhandles.get(1));
				
				File source = driver.getScreenshotAs(OutputType.FILE);
				File destination = new File("./snap/amazon.png/");
				FileUtils.copyFile(source,destination);
	
				
				driver.findElement(By.id("add-to-cart-button")).click();
				
				WebElement findElement = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']"));
				Thread.sleep(15000);
				//action.moveToElement(findElement).perform();
				String text2 = findElement.getText();
				Thread.sleep(15000);
				System.out.println(text2);
				
				File source1 = driver.getScreenshotAs(OutputType.FILE);
				File Destination1 = new File("./snap/amazon_final_screen.png");
				FileUtils.copyFile(source,destination);
				
	}

}
