package Task11;

import java.time.Duration;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Window {
	
public static void main(String[] args) throws InterruptedException {
		
		// Launch the ChromeDriver,implicit wait,Maximize the window and navigate to URL
		WebDriver driver=new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   
		driver.manage().window().maximize();  
		driver.get("https://the-internet.herokuapp.com/windows"); 
		
		//locating the 'click here' link by using link text to click
		driver.findElement(By.linkText("Click Here")).click(); 
		String ParentWindow=driver.getWindowHandle();   //Getting the id for Parent window
		
		//Storing all window's id to SET by using this method and to verify the new window's id
		Set <String> windowsID=driver.getWindowHandles(); 
		String ChildWindow = null;
		
		for (String WinIds:windowsID) 
		{
			String winnew=WinIds;
			if(!(ParentWindow==winnew))
				ChildWindow=winnew;
		}
		
		// Switch into new window
		driver.switchTo().window(ChildWindow);
		// Getting the text from new window
		String msg=driver.findElement(By.xpath("//h3[text()='New Window']")).getText(); 
		System.out.println("Title from the Present Window Page : " +msg);
		Thread.sleep(5000);
		driver.close();         //closing the opened new window
		
		//Switching into parent window
		driver.switchTo().window(ParentWindow);  
		String currentWindow=driver.getWindowHandle();
		System.out.println(" ");
		
		//verify the original window is active or not
		if(driver.getWindowHandle().equals(currentWindow))   
			System.out.println("Original Window is Active");
		else
			System.out.println("It's not the Original Window");
	}


}
