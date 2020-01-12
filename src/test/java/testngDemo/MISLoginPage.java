package testngDemo;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import genericMethods.WebElementMethods;

//Test class
public class MISLoginPage extends PropertyFile {
	public Properties prop;
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setUp()
	{
		prop=PropertyFile.ReadPropertyFile("./config.properties");
		System.setProperty(prop.getProperty("chrome_key"),prop.getProperty("chrome_value"));
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("impicitWait")), TimeUnit.SECONDS);
		driver.get(prop.getProperty("mis_url"));
	}
	
	
	@Test
	public void checkLogin()
	{
		MISLoginPageObject mis=new MISLoginPageObject(driver);
		mis.setUsername(prop.getProperty("username"));
		mis.setPassword(prop.getProperty("password"));
		mis.selectMIS();
		mis.clickLogin();
		WebElement ele=driver.findElement(By.xpath("//b[.='Home']"));
		WebElementMethods wb=new WebElementMethods();
		Assert.assertTrue(wb.isElementDisplayed(ele));
	}
	
	@AfterMethod
	public void browserquit()
	{
		driver.quit();
	}

}
