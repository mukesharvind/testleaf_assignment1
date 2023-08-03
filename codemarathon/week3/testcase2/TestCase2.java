package week3.codemarathon.testcase2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.utils.FileUtil;

public class TestCase2 extends BaseClass{
	
	@Test(dataProvider = "exceldata")
public  void oppurtunitycreation(String name, String amount) throws InterruptedException, IOException {
	
	
	
//	2. Click on toggle menu button from the left corner
	Thread.sleep(4000);
	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	
//	3. Click view All and click Sales from App Launcher
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	driver.findElement(By.xpath("//p[text()='Sales']")).click();
	
//	4. Click View All Key Deals in Key Deals 
	//WebElement movetoele = driver.findElement(By.xpath("(//div[@class='slds-card__footer'])[4]"));
	Actions action = new Actions(driver);
	
	
	WebElement viewalldeals = driver.findElement(By.xpath("//span[text()='View All Key Deals']"));
	driver.executeScript("arguments[0].click();",viewalldeals);
//	6. Click on New
	driver.findElement(By.xpath("//div[text()='New']")).click();
	
//	7. Give Opportunity Name  (From Excel)
	driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(name);
	
//	8. Select Type as New Customer and Lead Source as Partner Referral
	
	WebElement typedrop = driver.findElement(By.xpath("(//span[text()='--None--'])[2]"));
	
	driver.executeScript("arguments [0].click();",typedrop);
	
	WebElement newcustomer = driver.findElement(By.xpath("(//span[text()='New Customer'])[1]"));
	newcustomer.click();
	
	
	WebElement leadsource = driver.findElement(By.xpath("(//span[text()='--None--'])[3]"));
	driver.executeScript("arguments[0].click();",leadsource);
	
	WebElement partnerreferal = driver.findElement(By.xpath("//span[text()='Partner Referral']"));
	partnerreferal.click();
	

	
//	9. Give Amount as 75000 (from Excel)
	driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys(amount);

	
//	10. Select Close Date as tomorrow
	
	WebElement date = driver.findElement(By.xpath("//input[@name='CloseDate']"));
	driver.executeScript("arguments [0].click();",date);
	driver.findElement(By.xpath(" (//td[@role='gridcell']/span[@class='slds-day'])[6]")).click();
	
//	11. Select Stage as Needs Analysis
	WebElement stage = driver.findElement(By.xpath("(//span[text()='--None--'])[1]"));
	driver.executeScript("arguments [0].click();",stage);
	
	driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();

	
//	12. Click in Primary Campaign  Source and Select first option
	
	WebElement primarycamping = driver.findElement(By.xpath("(//label[text()='Primary Campaign Source']/following::input)[1]"));
	driver.executeScript("arguments [0].click();", primarycamping);
	driver.findElement(By.xpath("//span[@title='Bootcamp']")).click();
	
//	13. Click Save and Verify the opportunity is created"
	
	driver.findElement(By.xpath("//button[text()='Save']")).click();
	WebElement findElement = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
	String text = findElement.getText();
	System.out.println(text);
	
	
}
	@DataProvider
	public String[][] exceldata() throws IOException{
		return ReadExcel.readexceldata();
		
	}
}
