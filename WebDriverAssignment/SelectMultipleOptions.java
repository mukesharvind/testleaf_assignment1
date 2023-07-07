package WebDriverAssignment;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectMultipleOptions {
	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement ele = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));	
		
		Select dropdown1 = new Select(ele);
//		List<WebElement> allSelectedOptions = dropdown1.getOptions();
//		int sizeofthedropdown = allSelectedOptions.size();

		 
	   int size = dropdown1.getOptions().size();
		System.out.println("The size of the dropdown is " +size);
		
		for (int i = 0; i < size; i++) {
			
			dropdown1.getOptions().get(i);
			dropdown1.selectByIndex(i);
			Thread.sleep(3000);
		} 
		driver.close();
	}

}
