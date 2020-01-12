package testngDemo;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo1 {
	
	@BeforeMethod
	public void firstCheck()
	{
		Reporter.log("FirstBeforeMethodExecution", true);
	}
	
	@BeforeMethod
	public void SecondCheck()
	{
		Reporter.log("SecondBeforeMethodExecution", true);
	}
	
	@Test
	public void checkLifeReg()
	{
		Reporter.log("LifeRegExecution", true);
	}
	
	@Test
	public void checkPAReg()
	{
		Reporter.log("PARegExecution", true);
	}
	
	@Test
	public void checkHPReg()
	{
		Reporter.log("HPRegExecution", true);
	}

}
