package testngDemo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload {
	public static WebDriver driver;
	
	@Test
	public void fileUpload()
	{       
		try {    
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://easyupload.io/");
			Thread.sleep(2000);		
			WebElement clickHere=driver.findElement(By.xpath("//form[@class='valign-wrapper']"));
			clickHere.click();
			Robot r=new Robot();
			StringSelection filePath=new StringSelection("C:\\Users\\praveenn\\Desktop\\LeavePlan.xlsx");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath,null);
		        r.setAutoDelay(3000);	    
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			r.setAutoDelay(2000);
			WebElement submit = driver.findElement(By.xpath("//button[@id='upload']"));
			submit.click();	
			
				Thread.sleep(6000);
						
			WebElement exp=driver.findElement(By.xpath("//i[@class='arrow down']"));	
			/*exp.click();
			Point p=exp.getLocation();
			int x=p.getX();
			int y=p.getY();
			r.setAutoDelay(2000);
			WebElement oneDay = driver.findElement(By.xpath("//span[.='1 days']"));
			oneDay.click();
			r.setAutoDelay(2000);*/
			WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
			password.sendKeys("ct6813");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			//r.mouseMove(x, y);
			//r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			//r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		}
	
	}


