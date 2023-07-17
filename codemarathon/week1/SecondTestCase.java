package week1.codemarathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondTestCase {
	
	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//search bagsforboys
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags");
		driver.findElement(By.xpath("//div[@aria-label='bags for boys']")).click();
		
		//print searchresult
		WebElement ele1 = driver.findElement(By.xpath("//span[contains(text(),'1-48 of over 50,000 results for')]"));
		String searchresult = ele1.getText();
		System.out.println("The search result for 'bags for boys is' "+searchresult);
	
		//first 2 brands in the left menu
		
		driver.findElement(By.xpath("(//input[@type='checkbox']/following::i)[7]")).click();//there were 166 search result I treid with attributes xpath,sibling-xpath
		driver.findElement(By.xpath("(//input[@type='checkbox']/following::i)[8]")).click();
		
		//Choose New Arrivals (Sort)
		driver.findElement(By.xpath("//span[contains(text(),'Featured')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Newest Arrivals')]")).click();
		
		//print first two resulting bag name
		WebElement ele2 = driver.findElement(By.xpath("(//h2[@class='a-size-mini s-line-clamp-1']/span)[1]"));
		String firstbagname = ele2.getText();
		System.out.println("The bag name is "+firstbagname);
		
		WebElement ele3 = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		String discountedprice = ele3.getText();
		System.out.println("The discounted price is "+discountedprice);
		WebElement ele4 = driver.findElement(By.xpath("(//h2[@class='a-size-mini s-line-clamp-1']/span)[2]"));
		String secondbagname = ele4.getText();
		System.out.println("The bag name is "+secondbagname);
		
		//get title 
		
		String title = driver.getTitle();
		System.out.println("The title of the webpage is "+title);
		
		driver.close();
	}

}
