package genericMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class WebElementMethods {
	
	public boolean isElementDisplayed(WebElement ele)
	{
		boolean result=ele.isDisplayed();
		return result;
	}
	
	public boolean isElementEnabled(WebElement ele)
	{
		boolean result=ele.isEnabled();
		return result;
	}
	
	public boolean isElementSelected(WebElement ele)
	{
		boolean result=ele.isSelected();
		return result;
	}
	
	public String getTheAttributeValue(WebElement ele,String attributename)
	{
		String value=ele.getAttribute(attributename);
		return value;
	}
	
	public int getXaxis(WebElement ele)
	{
		Point p=ele.getLocation();
		int x=p.getX();
		return x;
	}
	
	public int getYaxis(WebElement ele)
	{
		Point p=ele.getLocation();
	    int y=p.getY();
		return y;
	}
	
	public String getTagNameOfElement(WebElement ele)
	{
		String value=ele.getTagName();
		return value;
	}
	
	public String getTextOfElement(WebElement ele)
	{
		String value=ele.getText();
		return value;
	}
	
	public String getCssPropertyValue(WebElement ele,String propertyName)
	{
		String value=ele.getCssValue(propertyName);
		return value;
	}
	
	public Dimension getSizeOfElement(WebElement ele)
	{
		Dimension size=ele.getSize();
		return size;
	}
	
	public int getHeightOfElement(WebElement ele)
	{
		int height=ele.getSize().getHeight();
		return height;
	}
	
	public int getWidthOfElement(WebElement ele)
	{
		int width=ele.getSize().getWidth();
		return width;
	}
	
	public void inputTheData(WebElement ele,String inputData)
	{
		ele.sendKeys(inputData);
	}
	
	public void clearTheData(WebElement ele)
	{
		ele.clear();
	}
	
	public void clickTheElement(WebElement ele)
	{
		ele.click();
	}
	
	public void submitTheForm(WebElement ele)
	{
		ele.submit();
	}
	
	public void findTheElement(WebElement ele,By by)
	{
		ele.findElement(by);
	}
	
	public void findTheElements(WebElement ele,By by)
	{
		ele.findElements(by);
	}
	
	
	
	
}
