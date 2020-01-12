package testngDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo2 {
	
	@Test
	public void checkLifeDereg()
	{
		Reporter.log("LifeDeregExecution", true);
	}
	
	@Test
	public void checkPADereg()
	{
		Reporter.log("PADeregExecution", true);
	}
	
	@Test
	public void checkHPDereg()
	{
		Reporter.log("HPDeregExecution", true);
	}
	
	

}
