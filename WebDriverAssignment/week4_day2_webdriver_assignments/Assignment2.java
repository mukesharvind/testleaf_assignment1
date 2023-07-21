package week4.day2.webdriver.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
	ChromeDriver driver = new ChromeDriver();
	
	driver.get("https://leafground.com/window.xhtml;jsessionid=node0ohpw87cjok1dz9p1fgudvj6l12019.node0");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//getting the parentwindow handle
	
	String parentwindow1 = driver.getWindowHandle();
	System.out.println("The parent window is "+parentwindow1);
	
	//get title
	String title1 = driver.getTitle();
	System.out.println("The title of parent window is "+title1);
	//clicking the first option
	driver.findElement(By.xpath("//button[@id='j_idt88:new']")).click();
	
	Set<String> windowHandles = driver.getWindowHandles();
	int size = windowHandles.size();
	System.out.println("The size of the windows is "+size);
	
	for (String string1 : windowHandles) {
		System.out.println("Total number of windows are "+string1);
	
	}
	List<String>listofwindows = new ArrayList<String>(windowHandles);
	WebDriver window = driver.switchTo().window(listofwindows.get(1));
	String title2 = driver.getTitle();
	if (!title1.equals(title2)) {
		System.out.println("The new window has opened");
	}
	else {
		System.out.println("The new window has not opened");
	}
	driver.close();
	
	//getting the control back to parentwindow
	driver.switchTo().window(parentwindow1);
	
	//moving to another window find number of opened tabs
	driver.findElement(By.xpath("//span[contains(text(),'Open Multiple')]")).click();
	Set<String> windowHandles2 = driver.getWindowHandles();
	for (String string2 : windowHandles2) {
	System.out.println("Total number of windows are "+string2);
}	
	//getting the total number of windows opened
	int size2 = windowHandles2.size();
	System.out.println("The total number of windoes opened are "+size2);
	
	List<String>lisofwindows2 =new ArrayList<String>(windowHandles2);
	
	//switching to childwindow1 and closing it
	driver.switchTo().window(lisofwindows2.get(1));
	Thread.sleep(3000);
	driver.close();
	
	////switching to childwindow2 and closing it
	driver.switchTo().window(lisofwindows2.get(2));
	Thread.sleep(3000);
	driver.close();
	//switiching the control to parentwindow
	driver.switchTo().window(parentwindow1);
	driver.findElement(By.xpath("//span[contains(text(),'Close Windows')]")).click();
	
	Set<String> windowHandles3 = driver.getWindowHandles();
	List<String>lisofwindows3 = new ArrayList<String>(windowHandles3);
	
	int size3 = lisofwindows3.size();
	System.out.println("Total number of windows opened "+size3);
	
	driver.switchTo().window(lisofwindows3.get(1));
	driver.close();
	
	driver.switchTo().window(lisofwindows3.get(2));
	driver.close();
	
	driver.switchTo().window(lisofwindows3.get(3));
	driver.close();
	
	driver.switchTo().window(parentwindow1);
	driver.findElement(By.xpath("//span[contains(text(),'Open with delay')]")).click();
	
	Set<String> windowHandles4 = driver.getWindowHandles();
	
	List<String> listofwindows4 = new ArrayList<String>(windowHandles4);
	int size4 = listofwindows4.size();
	
	System.out.println("The total number of windows opened are "+size4);
	
	driver.switchTo().window(listofwindows4.get(1));
	Thread.sleep(3000);
	driver.close();
	
	driver.switchTo().window(listofwindows4.get(2));
	Thread.sleep(3000);
	driver.close();
	
	driver.switchTo().window(parentwindow1);
	Thread.sleep(2000);
	driver.close();
	
	}
	

}
