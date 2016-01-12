package abcpack;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class MultipleWindow {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.salesforce.com/");
		
		driver.findElement(By.xpath("//span[.='Sales']")).click();
		driver.findElement(By.xpath("//a[.='Watch Demo']")).click();
		
		//Get and store both window handles in array 
		Set<String> AllWindowHandles = driver.getWindowHandles(); 
		String window1 = (String) AllWindowHandles.toArray()[0]; 
		System.out.println("window1 handle code = "+AllWindowHandles.toArray()[0]); 
		
		String window2 = (String) AllWindowHandles.toArray()[1]; 
		System.out.println("window2 handle code = "+AllWindowHandles.toArray()[1]);
		
		//Switch to window2(child window) and performing actions on it. 
		driver.switchTo().window(window2); 
		driver.findElement(By.name("UserFirstName")).sendKeys("Selenium");
		Thread.sleep(5000);
		
		
		//Switch to window2(child window) and performing actions on it. 
		driver.switchTo().window(window1); 
		driver.findElement(By.linkText("Features")).click();
				
		
		

	}

}
