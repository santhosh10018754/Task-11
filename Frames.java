package Task11;

import java.time.Duration;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Frames {

public static void main(String[] args) {
		
		// Launch the ChromeDriver,implicit wait,Maximize the window and navigate to URL
		WebDriver driver=new ChromeDriver();   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://the-internet.herokuapp.com/nested_frames"); 
		driver.manage().window().maximize();   
		
		// Switch into top frame
		WebElement topframe=driver.findElement(By.xpath("//frame[@name='frame-top']")); 
		driver.switchTo().frame(topframe);
		
		// Calculating the number of frames and verifying the number of frames are 3 or not
		List <WebElement> frames=driver.findElements(By.xpath("//frame"));
		int framesize=frames.size();   
		if(framesize==3)   
			System.out.println("Test Pass: There are 'Three Frames' on the page ");
		else
			System.out.println("Test Fail: Total number of frames on the page is : "+framesize);
		
		// Switching into left frame and reading the message from that frame
		WebElement leftframe=driver.findElement(By.xpath("//frame[@name='frame-left']"));
		driver.switchTo().frame(leftframe);
		System.out.println();
		String message1=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();
		Assert.assertEquals("LEFT", message1);
		System.out.println("Verified,This frame has text of : " +message1);
		driver.switchTo().parentFrame(); //Switching into Top frame
		
		//Switching into Middle frame and reading the message from that frame
		WebElement middleframe=driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		driver.switchTo().frame(middleframe);
		System.out.println();
		String message2=driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]")).getText();
		Assert.assertEquals("MIDDLE", message2);
		System.out.println("Verified,This frame has text of : " +message2);
		driver.switchTo().parentFrame();  //Switching into Top frame
		
		//Switching into right frame and reading the message from that frame
		WebElement rightframe=driver.findElement(By.xpath("//frame[@name='frame-right']"));
		driver.switchTo().frame(rightframe);
		System.out.println();
		String message3=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText();
		Assert.assertEquals("RIGHT", message3);
		System.out.println("Verified,This frame has text of : " +message3);
		driver.switchTo().defaultContent(); //Switching into web page
		
		//Switching into bottom frame and reading the message from that frame
		WebElement bottomframe=driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
		driver.switchTo().frame(bottomframe);
		System.out.println();
		String message4=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText();
		Assert.assertEquals("BOTTOM", message4);
		System.out.println("Verified,This frame has text of : " +message4);
		driver.switchTo().defaultContent();   //Switching into web page
		driver.switchTo().frame(topframe);    //Switching into top frame
		
		//Verifying the title of page
		String title=driver.getTitle();     
		System.out.println();
		if (title=="Frames")
			System.out.println("Verified,Title of page is mathcing with Frames");
		else
			System.out.println("Unverified,Title of page is unmathcing with Frames");
	}

}
