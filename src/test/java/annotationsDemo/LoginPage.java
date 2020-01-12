package annotationsDemo;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginPage extends GenericMethods {
	GenericMethods gen;
	
	/*@Test
	public void login()
	{
		System.out.println("*******HardAssert Execution Started*******");
		driver.findElement(By.id("username")).sendKeys("3933");
		driver.findElement(By.id("password")).sendKeys("Kartic@9632");
		driver.findElement(By.id("MIS")).click();
		driver.findElement(By.id("mySelect")).click();
	}*/
	
	@Test
	public void testLoginUsingAssertPass()
	{
		System.out.println("*******HardAssert Execution Started*******");
		/*driver.findElement(By.id("username")).sendKeys("3933");
		driver.findElement(By.id("password")).sendKeys("Kartic@9632");
		driver.findElement(By.id("MIS")).click();
		driver.findElement(By.id("mySelect")).click();*/
		gen=new GenericMethods();
		gen.login();
		String title=driver.getTitle();
	    System.out.println(title);
	    Assert.assertEquals(title, "MIS Home");
	    System.out.println("TestCase Completed");
	    
	    /*
	     * Alternate way for Dynamic Title
	     * Assert.assertTrue(title.contains("MIS"));
	    System.out.println("TestCase Completed");*/
	}
	
	@Test
	public void testLoginUsingAssertFail()
	{
		System.out.println("*******HardAssert Execution Started*******");
		driver.findElement(By.id("username")).sendKeys("3933");
		driver.findElement(By.id("password")).sendKeys("Kartic@9632");
		driver.findElement(By.id("MIS")).click();
		driver.findElement(By.id("mySelect")).click();
		String title=driver.getTitle();
	    System.out.println(title);
	    Assert.assertEquals(title, "MIS");
	    System.out.println("TestCase Completed");
	}
	
	@Test
	public void testLoginUsingSoftAssertFail()
	{
		System.out.println("*******SoftAssert Execution Started*******");
		driver.findElement(By.id("username")).sendKeys("3933");
		driver.findElement(By.id("password")).sendKeys("Kartic@9632");
		driver.findElement(By.id("MIS")).click();
		driver.findElement(By.id("mySelect")).click();
		String title=driver.getTitle();
	    System.out.println(title);
	    SoftAssert sa=new SoftAssert();
	    sa.assertEquals(title, "MIS");
	    System.out.println("TestCase Completed");
	    //Compulsory to be mentioned
	    sa.assertAll();
	}
	
	@Test
	public void testLoginUsingSoftAssertPass()
	{
		System.out.println("*******SoftAssert Execution Started*******");
		driver.findElement(By.id("username")).sendKeys("3933");
		driver.findElement(By.id("password")).sendKeys("Kartic@9632");
		driver.findElement(By.id("MIS")).click();
		driver.findElement(By.id("mySelect")).click();
		String title=driver.getTitle();
	    System.out.println(title);
	    SoftAssert sa=new SoftAssert();
	    sa.assertEquals(title, "MIS Home");
	    System.out.println("TestCase Completed");
	    //Compulsory to be mentioned
	    sa.assertAll();
	    
	}
	
	@Test
	public void checkError()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement ele=driver.findElement(By.xpath("//input[@name='uploaded_file' and @type='file' and @class='pole_plik']"));
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		driver.findElement(By.name("file_description")).sendKeys("Karthick J");
		driver.findElement(By.xpath("//img[@src='images/button_upload.gif']")).click();
		}

}
