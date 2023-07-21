package week2.codemarathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class OrderingMobile {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-nottifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		//login the browser
		driver.get("https://dev31913.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("q+NozS5Qe8!E");
		driver.findElement(By.id("sysverb_login")).click();
		
		
		// Click-All Enter Service catalog in filter navigator and press enter or Click the ServiceCatalog
		
		Shadow dom = new Shadow(driver);
		Thread.sleep(5000);
		WebElement clickAllFilter = dom.findElementByXPath("//div[text()='All']");
		clickAllFilter.click();
		Thread.sleep(5000);
	
		WebElement ClickServiceCatalog = dom.findElementByXPath("//span[text()='Service Catalog']");
		ClickServiceCatalog.click();
	
		//Click on  mobiles
		WebElement frameele = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frameele);		
		
		WebElement mobile = dom.findElementByXPath("//a[text()='Mobiles']");
		mobile.click();
		
		
		//Select Apple iphone6s
		driver.findElement(By.xpath("//strong[contains(text(),'iPhone 6s')]")).click();
	
		//Update color field to Rose gold and storage field to 128GB
		WebElement colour = driver.findElement(By.xpath("//select[@name='IO:8350086e4f334200086eeed18110c7cd']"));
		
		Select colourdropdown = new Select(colour);
		colourdropdown.selectByIndex(3);
		WebElement gigsdropdown = driver.findElement(By.xpath("//select[@id='IO:32e0886e4f334200086eeed18110c738']"));
		Select gigs = new Select(gigsdropdown);
		gigs.selectByIndex(2);
		
		//Select  Order now option
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		
		//Verify order is placed and copy the request number"
		String title = driver.getTitle();
		System.out.println("The title of the page is :"+title);
		
		String confirmationtext = driver.findElement(By.xpath("//span[text()='Thank you, your request has been submitted']")).getText();
		System.out.println(confirmationtext);
		
		String RequestNumber = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
		System.out.println("Request number is : "+RequestNumber);
		
		if (title.contains(RequestNumber)) {
			System.out.println("The order is placed");
		}
			else {
				System.out.println("The order is not placed");
			}
		//screenshot
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snap/orderconfirmation.png");
		FileUtils.copyFile(source, destination);
		Thread.sleep(3000);
		
		driver.close();
	}
	}


