package annotationsDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class GenericMethods {
	public WebDriver driver;
	
	@BeforeMethod
	public void openApp()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("https://mis.thbs.com/RMS/home.jsp#");
		//driver.get("http://www.tinyupload.com/");
		driver.get("https://easyupload.io/");
		
	
		
		
	}

	@AfterMethod
	public void closeApp()
	{
		//driver.quit();
	}
	
	public void login()
	{
		driver.findElement(By.id("username")).sendKeys("3933");
		driver.findElement(By.id("password")).sendKeys("Kartic@9632");
		driver.findElement(By.id("MIS")).click();
		driver.findElement(By.id("mySelect")).click();
	}
}
