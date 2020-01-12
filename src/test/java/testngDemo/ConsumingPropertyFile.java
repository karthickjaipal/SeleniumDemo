package testngDemo;

import java.util.Properties;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class ConsumingPropertyFile extends PropertyFile {

	// Reading data from properties file and passing through the Script
	//Pass karthick credentials
	@Test
	public void Result()
	{
		Properties prop=PropertyFile.ReadPropertyFile("./config.properties");
		String username=prop.getProperty("username");
		Reporter.log(username, true);
		String password=prop.getProperty("password");
		Reporter.log(password, true);
	}
	
	//Pass praveen credentials
	@Test
	public void Result2()
	{
		Properties prop=PropertyFile.ReadPropertyFile("./config2.properties");
		String username=prop.getProperty("username");
		Reporter.log(username, true);
		String password=prop.getProperty("password");
		Reporter.log(password, true);
	}
	
	//Reading data from testNG.xml file and passing the same into scripts using @Parameters
	
	@Parameters({"username","password"})
	@Test
	public void ResultTwo(String username, String password)
	{
		Reporter.log(username, true);
		Reporter.log(password, true);
	}
}
