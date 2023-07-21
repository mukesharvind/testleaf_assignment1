package week4.day2.webdriver.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		//launching the website
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Go to Mens Fashion and Go to Sports Shoes
		Actions action = new Actions(driver);
		WebElement MensFashion = driver.findElement(By.xpath("(//span[contains(text(),' Fashion')])[1]"));
		action.moveToElement(MensFashion).perform();
		
		WebElement SportsShoesForMen = driver.findElement(By.xpath("(//span[contains(text(),'Sports Shoes')])[1]"));
		action.click(SportsShoesForMen).perform();
		
		//get the count of sportshoes
		WebElement countofsportsshoes = driver.findElement(By.xpath("//span[@class='category-name category-count']"));
		String count = countofsportsshoes.getText();
		System.out.println("The count of sports shoe is "+count);
		
		//click training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
	
		
		//Sort by low to high
		Thread.sleep(5000);
		WebElement sortby = driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']"));
		sortby.click();
		//action.click(sortby).perform();
		Thread.sleep(5000);
		WebElement PriceLowtoHigh = driver.findElement(By.xpath("(//li[@data-index='1'])[2]"));
		
		PriceLowtoHigh.click();
		
		//action.click(PriceLowtoHigh).perform();
		
		
		
		List<WebElement> pricelist = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		int size = pricelist.size();
		System.out.println("The total number of shoes is "+size);
		
		List<String>price = new ArrayList<String>();
		for (WebElement each : pricelist) {
			String text = each.getText();
			price.add(text);
			
		}
		String minvalue = price.get(0);
		
		Collections.sort(price);
		
		System.out.println("The list of sorted prices are " +price);
		String min = Collections.min(price);
		
		//Check if the items displayed are sorted correctly
		if (min.equalsIgnoreCase(minvalue)) {
			System.out.println("Both are equal");
		}
		else {
			System.out.println("Both are not equal");
		}
		//Select the price range (900-1200)
		WebElement PriceRange1 = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
		PriceRange1.clear();
		PriceRange1.sendKeys("500");
		WebElement PriceRange2 = driver.findElement(By.xpath("(//input[@type='text'])[6]"));
		PriceRange2.clear();
		PriceRange2.sendKeys("650");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		
		//select by navy colour
		
		WebElement navyblue = driver.findElement(By.xpath("//a[text()=' Black']"));
		action.scrollToElement(navyblue).perform();
		action.click(navyblue).perform();
		
		//Mouse Hover on first resulting Training shoes
		WebElement FirstTrainingShoe = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		action.scrollToElement(FirstTrainingShoe);
		action.moveToElement(FirstTrainingShoe);
		
		String ParentWindow = driver.getWindowHandle();
		System.out.println("The parent window name is "+ParentWindow);
	
//		Thread.sleep(5000);
//		WebElement scrollto = driver.findElement(By.xpath("//span[text()='Did you find what you are looking for? ']"));
//		action.scrollToElement(scrollto).perform();
//		Thread.sleep(5000);
		WebElement mousehover = driver.findElement(By.xpath("(//source[@class='product-image']/following::img)[1]"));		
		action.moveToElement(mousehover).perform();		
		Thread.sleep(5000);
		
		WebElement QuickView = driver.findElement(By.xpath("//div[contains(text(),'Quick View')]"));
		action.moveToElement(QuickView).perform();
		Thread.sleep(3000);
		QuickView.click();
		
		//application UI changed

		driver.findElement(By.xpath("//a[contains(text(),'view details')]")).click();
		String DiscountedPrice = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		String ActualPrice = driver.findElement(By.xpath("//div[@class='pdpCutPrice ']")).getText();
		String discountpercentage = driver.findElement(By.xpath("//span[@class='pdpDiscount ']")).getText();
		System.out.println("The discounted price is "+DiscountedPrice);
		System.out.println("The actual price is "+ActualPrice);
		System.out.println("The discount percentage is "+discountpercentage);
		
//		Set<String> lisofwindow = driver.getWindowHandles();
//		for (String string : lisofwindow) {
//			System.out.println("The window handles are "+lisofwindow);
//		}
//		
		
		
//		List<String>childwindow = new ArrayList<String>(lisofwindow);
//		driver.switchTo().window(childwindow.get(1));
//		
//		String discountedprice = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
//		System.out.println("The discounted price of the shoe is "+discountedprice);
//		String dicountpercentage = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
//		System.out.println("The discounted percentage is "+dicountpercentage);
//		
//		driver.close();
//	
//		driver.switchTo().window(ParentWindow);
		driver.close();
	}

}
