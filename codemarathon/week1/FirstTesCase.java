package week1.codemarathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstTesCase {
	
	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.abhibus.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//04) Type "Chennai" in the FROM text b
		driver.findElement(By.xpath("//a[@id='pills-home-tab']")).click();
		driver.findElement(By.xpath("//input[@id='source']")).sendKeys("chen");
		driver.findElement(By.xpath("//li[contains(text(),'Chennai')]")).click();
		
		
		// Click the first option from the pop up box(use click)
		 
		driver.findElement(By.xpath("//input[@id='destination']")).sendKeys("Bang");
		driver.findElement(By.xpath("(//li[contains(text(),'Bangalore')])[1]")).click();
		
		//Select tomorrow's date in the Date field Click Search Buses
		driver.findElement(By.xpath("(//input[@class='form-control border-0 mb-0 hasDatepicker'])[1]")).click();
		driver.findElement(By.xpath("(//td[@data-month='6'])[2]/a")).click();
		
		driver.findElement(By.xpath("//a[@class='btn btn-main px-5 py-2 border-right-radius']")).click();
		
		// Print the name of the first resulting bus (use .getText())
		WebElement element1 = driver.findElement(By.xpath("(//h2[@class='TravelAgntNm ng-binding'])[1]"));
		String busname = element1.getText();
		System.out.println("The bus name is "+busname);
		
		//Choose SLEEPER in the left menu from Bus Type
		driver.findElement(By.xpath("//input[@id='Bustypes4']")).click();
		
		//Print the first resulting bus seat count(Example:35 Seats Available)(use .getText()),Click SelectSeat
		WebElement ele2 = driver.findElement(By.xpath("(//p[@class='noseats AvailSts ng-binding'])[1]"));
		String availableseats = ele2.getText();
		System.out.println("The available seats are "+availableseats );
		
		driver.findElement(By.xpath("(//span[@class='book'])[1]")).click();
		
		//Choose any one Available seat Print Seats Selected ,Total Fare
		driver.findElement(By.xpath("(//a[@class='tooltip tooltipstered'])[1]")).click();
		WebElement ele3 = driver.findElement(By.xpath("//span[@id='ticketfare']"));
	    String totalamount = ele3.getText();
	    System.out.println("Total amount is "+totalamount);
	    Thread.sleep(3000);
	    
	    //Select Boarding Point  and Dropping Point 
	    WebElement ele4 = driver.findElement(By.xpath("//select[@id='boardingpoint_id']"));
	    
	    Select boardingpoint = new Select(ele4);
	    
	    boardingpoint.selectByIndex(3);
	    WebElement ele5 = driver.findElement(By.xpath("//div[@class='red-landmark']"));
	    String boardinglocation = ele5.getText();
	    System.out.println("The boarding location is "+boardinglocation);
	    
	    WebElement ele6 = driver.findElement(By.id("droppingpoint_id"));
	    
	    Select dropingpoint = new Select(ele6);
	    dropingpoint.selectByIndex(3);
	    
	    driver.findElement(By.id("btnEnable1")).click();
	    
	    //Get the Title of the page(use .getTitle())
	    String title = driver.getTitle();
	    System.out.println("The title of the webpage is " +title);
	
	    driver.close();
	}

}
