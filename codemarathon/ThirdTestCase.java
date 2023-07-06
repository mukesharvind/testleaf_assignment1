package week1.codemarathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ThirdTestCase {
	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click  on Movie Library
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[contains(text(),'Movie Library ')]")).click();
		
		
		//Select the City -->chennai
		Thread.sleep(10000);
		WebElement ele1 = driver.findElement(By.xpath("//select[@name='city']"));
		Select dropdown1 = new Select(ele1);
		dropdown1.selectByVisibleText("Chennai");
		int i = dropdown1.getOptions().size();
		System.out.println("Total number of cities is " +i);
		
		//Select the Genre-->Animation
		WebElement ele2 = driver.findElement(By.xpath("//select[@name='genre']"));
		Select dropdown2 = new Select(ele2);
		dropdown2.selectByIndex(3);
		int j = dropdown2.getOptions().size();
		System.out.println("Total number of genere is "+j);
		
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		
		// Click on first resulting animation movie,Click proceed to book
		 
		WebElement ele3 = driver.findElement(By.xpath("//div[contains(text(),'Paw Patrol')]"));
		String firstanime = ele3.getText();
		System.out.println("The first anime is "+firstanime);
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@class='movie-wrapper ng-star-inserted']/img)[1]")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Proceed To Book')]")).click();
		
		
		//Enter the all fields  cinema , Name, date, Prefered show time, no of seats, food and beverages,Email and Mobile
		WebElement ele4 = driver.findElement(By.xpath("//select[@id='cinemaName']"));
		
		Select dropdown3 = new Select(ele4);
		dropdown3.selectByValue("SPI S2 Theyagaraja Chennai");
		
		driver.findElement(By.xpath("(//input[@type='text'])[6]")).click();
		driver.findElement(By.xpath("//span[@class='day-unit ng-star-inserted'][1]")).click();
		
		WebElement ele5 = driver.findElement(By.xpath("//select[@name='timings']"));
		Select dropdown4 = new Select(ele5);
		dropdown4.selectByIndex(3);
				
		driver.findElement(By.xpath("//input[@name='noOfTickets']")).sendKeys("2");
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Mukesh");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("mu@gmail.com");
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("2468101215");
		
		WebElement ele6 = driver.findElement(By.xpath("//select[@name='food']"));
		Select dropdown5 = new Select(ele6);
		dropdown5.selectByVisibleText("Yes");
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys("Movie");
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//label[@class='custom-control custom-radio']")).click();

		Thread.sleep(10000);
		
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		
		//12) Click cancel on OTP dialogbox 13) Close the OTP dialog box
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//button[@class='btn already-member'])[4]")).click();
		
		Thread.sleep(10000);
		//driver.findElement(By.xpath("//button[@class='swal2-close']"));
		////button[contains(text(),'×')]
		driver.findElement(By.xpath("//button[contains(text(),'×')]")).click();
		Thread.sleep(10000);
		String title = driver.getTitle();
		System.out.println("The title of the webpage is " +title);
		driver.close();
	
	}

	
}
