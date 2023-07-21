package week2.codemarathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.messages.types.Source;
import io.github.sukgu.Shadow;

public class ArchitectCertifications {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-nottifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		//login the browser
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement UserName = driver.findElement(By.id("username"));
		UserName.sendKeys("hari.radhakrishnan@qeagle.com");
		
		
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		
		
		// Click on Learn More link in Mobile Publisher
				String ParentWindow = driver.getWindowHandle();
				System.out.println("The parent winodw handle is "+ParentWindow);
				driver.findElement(By.xpath("//span[text()='Learn More']")).click();
				
				//iterate through the windows
				Set<String> ChildWindows = driver.getWindowHandles();
						for (String eachwindow : ChildWindows) {
							System.out.println("The list of windows are "+eachwindow);
						}
				//switching the control to  childwindow
					List<String> listofwindows = new ArrayList<String>(ChildWindows);
					driver.switchTo().window(listofwindows.get(1));
					String currentUrl = driver.getCurrentUrl();
				System.out.println("The URL is : "+currentUrl);
				
				//Click confirm on Confirm redirect
					driver.findElement(By.xpath("//button[text()='Confirm']")).click();
				
					driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
				
				//Click Learning 
					Shadow dom = new Shadow(driver);
					dom.findElementByXPath("//span[text()='Learning']").click();
				
				// And mouse hover on Learning On Trailhead
					WebElement LearningOnTrailhead = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
					Actions action = new Actions(driver);
					action.moveToElement(LearningOnTrailhead).perform();
					
		
 // Click on Salesforce Certifications
					Thread.sleep(4000);
					WebElement SalesforceCertification = dom.findElementByXPath("//p[contains(text(),'Earn resume-worthy Salesforce credentials. ')]");
					WebElement Link = dom.findElementByXPath("//a[text()='Salesforce Certification']");
					Thread.sleep(10000);
					action.scrollToElement(SalesforceCertification).perform();
					Thread.sleep(10000);
					
					action.moveToElement(Link).perform();
					action.click(Link).perform();	
										
	//Choose Your Role as Salesforce Architect
				driver.findElement(By.xpath("//div[text()='Architect']")).click();
	//Get the Text(Summary) of Salesforce Architect 
			WebElement CurrentRole = driver.findElement(By.xpath("//h1[text()='Salesforce Architect']"));	
action.scrollToElement(CurrentRole).perform();
WebElement RoleSummary = driver.findElement(By.xpath("//div[contains(text(),' Salesforce Architects are the most trusted digital advisors and respected team leaders in the ecosystem. They’re big-picture thinkers and ')]"));
String text = RoleSummary.getText();
System.out.println("The job role summary is "+text);

//Get the List of Certifications available				
WebElement scrollto = driver.findElement(By.xpath("//h1[text()='Salesforce Architect Credentials']"));
action.scrollToElement(scrollto).perform();

List<WebElement> listofcertificates = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
				int size = listofcertificates.size();
				System.out.println("The total number of certificates is "+size);
	
				List<String>certificatesArchitect = new ArrayList<String>();
	
				for (WebElement each : listofcertificates) {
					String text2 = each.getText();
					certificatesArchitect.add(text2);
					
				}
				System.out.println("The certificates are "+ certificatesArchitect);
				
		
				WebElement naviagtetocertification = driver.findElement(By.xpath("//h1[contains(text(),'What is an Architect?')]"));
				action.scrollToElement(naviagtetocertification).perform();
				
				File source = driver.getScreenshotAs(OutputType.FILE);
				File Destination = new File("./snap/Architect.png/");
				FileUtils.copyFile(source, Destination);
				
				driver.close();
				
				driver.switchTo().window(ParentWindow);
				driver.close();
				
	}

}
