package week3.codemarathon.testcase1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase1 extends BaseClass{
	
@Test (dataProvider = "senddata")
public void typequestion(String que, String ans) throws InterruptedException    {
	
	

//		3. Click on the App Launcher (dots)
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
//		4. Click View All
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
//		5. Type Content on the Search box
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("content");
		
//		6. Click Content Link
		driver.findElement(By.xpath("//mark[text()='Content']")).click();

//		7. Click on Chatter Tab
		WebElement chatterclick = driver.findElement(By.xpath("//span[text()='Chatter']"));
		driver.executeScript("arguments[0].click()",chatterclick);
		
//		8. Verify Chatter title on the page
		
		String title = driver.getTitle();
		System.out.println("The title is "+title);
		String titleverify ="Lightning Experience";
		if (title.equalsIgnoreCase(titleverify)) {
			System.out.println("Title is verified");
		}
		else {
			System.out.println("Title is not verified");
		}
//		9. Click Question tab
		
		driver.findElement(By.xpath("//span[text()='Question']")).click();
//		10. Type Question with data (coming from excel)
		driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys(que);
//		11. Type Details with data (coming from excel)
		driver.findElement(By.xpath("//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-text-color_weak slds-grow']")).sendKeys(ans);
//		12. Click Ask
		
		driver.findElement(By.xpath("//button[@title='Click, or press Ctrl+Enter']")).click();

//		13. Confirm the question appears
		String text = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText();
		System.out.println(text);
		
		
		
	}
@DataProvider
	public String[][] senddata() throws IOException {
		
	return ReadExcel.readexceldata();
	}


}
