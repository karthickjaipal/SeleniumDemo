package genericMethods;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class WebDriverMethods {
	
	public void launchUrl(WebDriver driver,String url)
	{
		driver.get(url);
	}
	
	public String getTheCurrentUrl(WebDriver driver)
	{
		String url=driver.getCurrentUrl();
		return url;
	}
	
	public String getThePageSource(WebDriver driver)
	{
		String src=driver.getPageSource();
		return src;
	}
	
	public String getTitleOfPage(WebDriver driver,String url)
	{
		String title=driver.getTitle();
		return title;
	}
	
	public void browserForwardAction(WebDriver driver)
	{
		driver.navigate().forward();
		
	}
	
	public void browserBackAction(WebDriver driver)
	{
		driver.navigate().back();
		
	}
	
	public void refreshPage(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	
	public void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	public void closeBrowser(WebDriver driver)
	{
		driver.close();
	}

	public void maximizeBrowserWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void deleteCookies(WebDriver driver)
	{
		driver.manage().deleteAllCookies();
	}
	
	public void openUrl(WebDriver driver,String url)
	{
		driver.navigate().to(url);
	}
	
	public void implicitWait(WebDriver driver, long time)
	{
		
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public void switchToAlert(WebDriver driver)
	{
		driver.switchTo().alert();
	}
}
