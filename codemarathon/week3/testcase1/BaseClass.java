package week3.codemarathon.testcase1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {

public ChromeOptions options;
public ChromeDriver driver;

@Parameters({"url","username","password"})	
@BeforeMethod
	public void preconditons(String url, String uname, String pword) {
		options = new ChromeOptions();
	options.addArguments("--disable-notifications");
		driver = new ChromeDriver();
//		Test case : 002 (Edge)
//		1. Login to https://login.salesforce.com
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.id("Login")).click();
			
	
	}
	
	@AfterMethod
public void postconditons() throws IOException {
//		14.	close
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination= new File("./snap/askquestions.png");
		FileUtils.copyFile(source, destination);
		
		driver.close();	
	
	}
}
