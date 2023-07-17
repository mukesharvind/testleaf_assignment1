package week4.day1.webdriver.assignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IframesAssignmentweek4day1 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://buythevalue.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click on first product
		driver.findElement(By.xpath("(//a[@class='product-title'])[1]")).click();
		Thread.sleep(4000);
		//Handle frame1
		//driver.switchTo().frame("dummy-chat-button-iframe");
		
		//Thread.sleep(4000);
		//Handle Frame 2
		//driver.switchTo().frame("Shopify online store chat");
		//Thread.sleep(4000);
		
		//enter the zip code and click
		driver.findElement(By.id("wk_zipcode")).sendKeys("625014");
	    driver.findElement(By.xpath("//input[@type='button']")).click();
	    
	    // add products to the cart and click checkout
	    driver.findElement(By.id("product-add-to-cart")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'View Cart')])[2]")).click();
	    
	    driver.findElement(By.id("checkout")).click();
	    
	    //handling the alert
	    Alert alert = driver.switchTo().alert();
	    alert.accept();
	    
		
	    driver.close();
	}

}
