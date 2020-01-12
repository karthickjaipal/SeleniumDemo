package genericMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameClassMethods {
	
	public void switchToFrameOnIndex(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrameOnId(WebDriver driver,int id)
	{
		driver.switchTo().frame(id);
	}
	
	public void switchToFrameOnName(WebDriver driver,String name)
	{
		driver.switchTo().frame(name);
	}
	
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	public void switchToFrameOnElementAddress(WebDriver driver,WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	
	public void switchToPageFromFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}

}
