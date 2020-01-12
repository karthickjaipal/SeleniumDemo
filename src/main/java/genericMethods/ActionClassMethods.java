package genericMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionClassMethods {
	public Actions actions;
	
	public void performMouseHoverAction(WebDriver driver,WebElement ele)
	{
		actions=new Actions(driver);
		actions.moveToElement(ele).perform();
	}
	
	public void performDragAndDropAction(WebDriver driver,WebElement ele_source,WebElement ele_dest)
	{
		actions=new Actions(driver);
		actions.dragAndDrop(ele_source, ele_dest).perform();
	}
	
	public void performDoubleClickAction(WebDriver driver,WebElement ele)
	{
		actions=new Actions(driver);
		actions.doubleClick(ele).perform();
	}
	
	public void performRightClickAction(WebDriver driver,WebElement ele)
	{
		actions=new Actions(driver);
		actions.contextClick(ele).perform();
		
	}
	
	
}
