package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.LocatorsDemo;

public class Password extends LocatorsDemo{
	
    @FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	
	public Password(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterPassword()
	{
		password.sendKeys("9632758737");
	}

}
