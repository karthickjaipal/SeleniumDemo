package genericMethods;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectClassMethods {
	public Select s;
	
	public void selectByIndex(WebElement ele, int index)
	{
		s=new Select(ele);
		s.selectByIndex(index);
	}
	
	public void selectByValue(WebElement ele, String value)
	{
		s=new Select(ele);
		s.selectByValue(value);
	}
	
	public void selectByVisibleOptions(WebElement ele, String option)
	{
		s=new Select(ele);
		s.selectByVisibleText(option);
	}
	
	public void deSelectByIndex(WebElement ele, int index)
	{
		s=new Select(ele);
		s.deselectByIndex(index);
	}
	
	public void deSelectByValue(WebElement ele, String value)
	{
		s=new Select(ele);
		s.deselectByValue(value);
	}
	
	public List<WebElement> getAllOptions(WebElement ele)
	{
		s=new Select(ele);
		List<WebElement> options = s.getOptions();
		return options;
	}
	
	public boolean isMultiSelect(WebElement ele)
	{
		s=new Select(ele);
		boolean result = s.isMultiple();
		return result;
				
	}
	
	public void deSelectAllOptions(WebElement ele, String value)
	{
		s=new Select(ele);
		s.deselectAll();
	}
	
	public List<WebElement> getTheSelectedOptions(WebElement ele)
	{
		s=new Select(ele);
		List<WebElement> listofElements = s.getAllSelectedOptions();
		return listofElements;
	}
	
	public WebElement getTheFirstSelectedOption(WebElement ele)
	{
		s=new Select(ele);
		WebElement firstOption = s.getFirstSelectedOption();
		return firstOption;
	}
	

}
