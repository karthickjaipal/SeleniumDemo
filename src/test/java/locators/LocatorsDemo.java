package locators;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM.Password;

public class LocatorsDemo {
	public WebDriver driver;

	Password pwd;


	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();

	}

	@Test(enabled=false)
	public void facebookSigUp()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/campaign/landing.php?campaign_id=1653993517&extra_1=s%7Cc%7C355887219806%7Ce%7Cfacebook%20sign%20up%7C&placement=&creative=355887219806&keyword=facebook%20sign%20up&partner_id=googlesem&extra_2=campaignid%3D1653993517%26adgroupid%3D63066387563%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D1t1%26target%3D%26targetid%3Dkwd-5066597374%26loc_physical_ms%3D1007768%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=EAIaIQobChMI4IjxyaO55QIVFIWPCh2rvQMHEAAYASAAEgJ5DPD_BwE");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("abc");
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("xyz");
		driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("9632758736");
		driver.findElement(By.cssSelector("input[name='reg_passwd__']")).sendKeys("abc@123");
		Select birth_day=new Select(driver.findElement(By.cssSelector("select[id='day']")));
		birth_day.selectByValue("21");
		Select birth_month=new Select(driver.findElement(By.cssSelector("select[id='month']")));
		birth_month.selectByValue("3");
		Select birth_year=new Select(driver.findElement(By.cssSelector("select[id='year']")));
		birth_year.selectByValue("1994");
		driver.findElement(By.cssSelector("input[value='2']")).click();
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	@Test(enabled=false)
	public void googleSignIn() throws InterruptedException
	{
		driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.manage().window().maximize();
		pwd=new Password(driver);
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("karthickjaipal94@gmail.com");
		driver.findElement(By.cssSelector("span[class='CwaK9']")).click();
		Thread.sleep(3000);
		pwd.enterPassword();
		driver.findElement(By.cssSelector("span[class='CwaK9']")).click();
		String parentWindow = driver.getWindowHandle();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='gb_Kf']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Gmail']"))).click();
		String title= driver.getTitle();
		System.out.println("The gmail page title"+ title);
		String childWindow=driver.getWindowHandle();
		//Actions actions=new Actions(driver);
		driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("//div[contains(.,'Compose')]")).click();
		//WebDriverWait wait1=new WebDriverWait(driver,100);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(.,'Compose')]"))).click();
		// wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='New Message']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='to']"))).sendKeys("karthickjaipal94@gmail.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='subjectbox']"))).sendKeys("Myprofile");
	}


	@Test(enabled=false)
	public void youTubeCheck()
	{
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search']"))).sendKeys("kgf trailer");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='search-icon-legacy']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='KGF Trailer Hindi | Yash | Srinidhi | 21st Dec 2018']"))).click();
		String count= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//yt-formatted-string[contains(.,'KGF Trailer Hindi')]/ancestor::div[1]/descendant::span[1]"))).getText();
		System.out.println("The views count : " + count);

	}

	@Test(enabled=false)
	public void checkGoogleSearch()
	{
		driver.get("https://www.google.com/");
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='q']"))).sendKeys("Selenium");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='lga']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='btnK'])[2]"))).click();
		String actual_value=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Selenium Tutorial for Beginners: Learn WebDriver in 7 Days"))).getText();
		Assert.assertEquals(actual_value, "Selenium Tutorial for Beginners: Learn WebDriver in 7 Days");
	}


	@Test
	public void checkIsDisplayedTest()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/Demonew.html");
		WebElement ele= driver.findElement(By.xpath("//input[@id='a1']"));
		boolean b = ele.isDisplayed();
		if(b)
		{
			System.out.println("Textbox is displayed");	
		}else
		{
			System.out.println("Textbox is not displayed");
		}
	}

	@Test
	public void checkIsEnabledTest()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/Demonew.html");
		WebElement ele1= driver.findElement(By.xpath("//input[@id='c1']"));
		WebElement ele2= driver.findElement(By.xpath("//input[@id='c2']"));
		boolean b = ele1.isEnabled();
		if(b)
		{
			System.out.println("Checkbox is Enabled");	
		}else
		{
			System.out.println("Checkbox is disabled");
		}
		boolean b1 = ele2.isEnabled();
		if(b1)
		{
			System.out.println("Checkbox is Enabled");	
		}else
		{
			System.out.println("Checkbox is disabled");
		}
	}

	@Test
	public void checkClearTest()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/Demonew.html");
		WebElement ele= driver.findElement(By.xpath("//input[@id='a1']"));
		ele.clear();

		if((ele.getText()).isEmpty())
		{
			System.out.println("Textbox is cleared");	
		}else
		{
			System.out.println("Textbox is not cleared");
		}
	}

	@Test
	public void checkKeyFunctionsTest()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/Demonew.html");
		WebElement ele= driver.findElement(By.xpath("//input[@id='a1']"));
		ele.sendKeys(Keys.CONTROL+"a");
		ele.sendKeys(Keys.DELETE);
		if((ele.getText()).isEmpty())
		{
			System.out.println("Textbox is cleared");	
		}else
		{
			System.out.println("Textbox is not cleared");
		}
	}

	@Test
	public void checkKeysFunctionsTest()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/Demonew.html");
		WebElement ele= driver.findElement(By.xpath("//input[@id='a1']"));
		ele.sendKeys(Keys.CONTROL+"ac");
		WebElement ele1= driver.findElement(By.xpath("//input[@id='a2']"));
		ele1.sendKeys(Keys.CONTROL+"a");
		ele1.sendKeys(Keys.DELETE);
		ele1.sendKeys(Keys.CONTROL+"v");
		System.out.println(ele.getText());
		System.out.println(ele1.getText());
	}

	@Test
	public void checkgetAttributeValueTest()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/Demonew.html");
		WebElement ele= driver.findElement(By.xpath("//input[@id='a1']"));
		String myAttributeValue=ele.getAttribute("id");
		System.out.println("Value is :" + myAttributeValue );
	}

	//To get the path of the img
	@Test
	public void checkImageSourceTest()
	{
		driver.get("https://www.google.com/");
		WebElement ele= driver.findElement(By.xpath("//img"));
		String myImageSrc=ele.getAttribute("src");
		System.out.println("ImageSource is :" + myImageSrc );
	}

	//To get the text of the Link
	@Test
	public void checktextOfLinkTest()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/Demonew.html");
		WebElement ele= driver.findElement(By.xpath("//a"));
		String link_text=ele.getAttribute("href");
		System.out.println("Text of the link is :" + link_text );
	}

	//To get the text value of the element
	@Test
	public void checkTextValueTest()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/Demonew.html");
		WebElement ele= driver.findElement(By.xpath("//input[@id='a1']"));
		String myTextValue=ele.getText();
		System.out.println("Text value of element is :" + myTextValue );
	}

	//To get the fontsize,height and width of an element
	@Test
	public void checkCssValueTest()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/Demonew.html");
		WebElement ele= driver.findElement(By.xpath("//input[@id='a1']"));
		String fontsize=ele.getCssValue("font");
		System.out.println("font-size of element is :" + fontsize );

		/*String height=ele.getCssValue("height");
		System.out.println("height of element is :" + height );*/

		String width=ele.getCssValue("border-width");
		System.out.println("width of element is :" + width );


	}

	//To get the location of an element, x axis and y axis
	@Test
	public void checkLocationTest()
	{
		driver.get("https://www.google.com/");
		WebElement ele= driver.findElement(By.xpath("//img"));
		Point loc=ele.getLocation();
		System.out.println("Location of the element is :" + loc );

		// x axis:
		int x_axis=loc.getX();
		System.out.println("x-axis is : " + x_axis);

		// y axis:
		int y_axis=loc.getY();
		System.out.println("y-axis is : " + y_axis);

	}
	//To get the height and width without using getCSSValue() method
	@Test
	public void checkgetSizeTest()
	{
		driver.get("https://www.google.com/");
		WebElement ele= driver.findElement(By.xpath("//img"));
		int height=ele.getSize().getHeight();
		int width=ele.getSize().getWidth();
		System.out.println("height of the element is :" + height );
		System.out.println("width of the element is :" + width);


	}	
	//To check for Browser options actions
	@Test
	public void checkNavigateTest()
	{
		driver.navigate().to("https://www.google.com/");
		driver.navigate().to("file:///C:/Users/karthick_jaipal/Desktop/Demonew.html");
		//backward action
		driver.navigate().back();
		//forward action
		driver.navigate().forward();
		//refresh action
		driver.navigate().refresh();
	}

	//Pass the data into multiple textbox and clear 

	@Test
	public void checkClearMultipletextBoxTest()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/TextDemo.html");
		List<WebElement> textbox = driver.findElements(By.xpath("//input"));
		for(WebElement ele:textbox)
		{
			ele.sendKeys("Karthick");
			//ele.clear();
			for(int i=0;i<textbox.size();i++)
			{
				ele=textbox.get(i);
				ele.sendKeys(Keys.CONTROL+"a");
				ele.sendKeys(Keys.DELETE);

			}
		}
	}

	//To count the multiple links and get the text value
	@Test
	public void checkMultipleLinksTest()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/TextDemo.html");
		List<WebElement> Links = driver.findElements(By.xpath("//a"));
		int count=Links.size();
		System.out.println("The count of Links : "+ count);
		for(WebElement ele:Links)
		{
			String text_value=ele.getText();
			System.out.println("The textvalue of Links are :"+ text_value);
		}
	}

	//To count the number of dropdown, links and table elements
	@Test
	public void checkCountOfElementsTest()
	{
		driver.get("https://www.google.com/");
		List<WebElement> Links = driver.findElements(By.xpath("//a | //Select | //table"));
		int count=Links.size();
		System.out.println("The count of Links : "+ count);

	}

	//To get the url of multiple links
	@Test
	public void checkgetURLOfLinksTest()
	{
		driver.get("https://www.google.com/");
		List<WebElement> Links = driver.findElements(By.xpath("//a"));
		int count=Links.size();
		System.out.println("The count of Links : "+ count);
		for(WebElement ele:Links)
		{
			String url=ele.getAttribute("href");
			System.out.println("The url of Links are :"+ url);
		}
	}

	//To get the location of multiple links
	@Test
	public void checkgetLocationOfLinksTest()
	{
		driver.get("https://www.google.com/");
		List<WebElement> Links = driver.findElements(By.xpath("//a"));
		int count=Links.size();
		System.out.println("The count of Links : "+ count);
		for(WebElement ele:Links)
		{
			Point loc=ele.getLocation();
			int x=loc.getX();
			int y=loc.getY();
			System.out.println("The Location of Links is :"+ loc + "The x-axis value is :" + x + "The y-axis value is :" + y );
		}
	}

	//To get the path of Images
	@Test
	public void checkgetPathOfImagesTest()
	{
		driver.get("https://www.google.com/");
		List<WebElement> images = driver.findElements(By.xpath("//img"));
		int count=images.size();
		System.out.println("The count of images : " + count);
		for(WebElement ele:images)
		{
			String path=ele.getAttribute("src");
			System.out.println("The Path of Images is :" + path );
		}
	}

	//select the checkbox in forward direction(for each loop) and deselect(for loop) in reverse direction
	@Test
	public void checkSelectCheckboxTest()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/checkboxdemo.html");
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='Checkbox']"));
		int count=checkbox.size();
		System.out.println("The count of images : " + count);
		//select in forward
		for(WebElement ele:checkbox)
		{
			ele.click();

		}
		//deselect in reverse
		for(int i=count-1;i>=0;i--)
		{
			WebElement ele=checkbox.get(i);
			ele.click();
		}
	}
	// To do actions on dropdowns

	// To select single select dropdowns
	@Test
	public void selectSingleSelectDropdowns()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/dropdowndemo.html");
		WebElement ele= driver.findElement(By.xpath("//select[@id='mtr']"));
		Select sel=new Select(ele);
		sel.selectByIndex(1);
		sel.selectByValue("i");
		sel.selectByVisibleText("idly");

	}

	// To select Multiselect dropdowns and deselectAll
	@Test
	public void selectMultiselectSelectDropdowns()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/dropdowndemo.html");
		WebElement ele= driver.findElement(By.xpath("//select[@id='Iyengar']"));
		Select sel=new Select(ele);
		if(sel.isMultiple())
		{
			sel.selectByIndex(1);
			sel.selectByValue("i");
			sel.selectByVisibleText("idly");
		}
		sel.deselectAll();
	}

	// To print the number of options and get the text of all options 
	@Test
	public void checkGetoptionscountandPrintText()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/dropdowndemo.html");
		WebElement ele= driver.findElement(By.xpath("//select[@id='Iyengar']"));
		Select sel=new Select(ele);
		List<WebElement> options = sel.getOptions();
		System.out.println("The count of options is :" +options.size());
		System.out.println("The text value of options are: ");
		for(WebElement we: options)
		{

			System.out.println(we.getText());
		}

	}

	// To print the count of deselectedOptions
	@Test
	public void checkCountOfDeselectedOptions()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/dropdowndemo.html");
		WebElement ele= driver.findElement(By.xpath("//select[@id='Iyengar']"));
		Select sel=new Select(ele);
		List<WebElement> options = sel.getOptions();
		int total_count=options.size();
		System.out.println("The count of options is :" +total_count);
		//selecting options
		sel.selectByIndex(1);
		sel.selectByValue("i");
		sel.selectByVisibleText("idly");
		//getting all selected options list
		List<WebElement> seloptions = sel.getAllSelectedOptions();
		int selected_count=seloptions.size();
		System.out.println("The count of selected options is :" +selected_count);
		//deselectedCount
		int deselected_count=(total_count-selected_count);
		System.out.println("The count of deselected options is :" + deselected_count);


	}

	// To print the options in reverse order
	@Test
	public void checkPrintOptionsReverse()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/dropdowndemo.html");
		WebElement ele= driver.findElement(By.xpath("//select[@id='Iyengar']"));
		Select sel=new Select(ele);
		List<WebElement> options = sel.getOptions();
		int total_count=options.size();
		System.out.println("The count of options is :" +total_count);
		System.out.println("The textOptions in reverse are");
		for(int i=total_count-1;i>=0;i--)
		{
			String Text=options.get(i).getText();

			System.out.println(Text);
		}
		//selecting options
		sel.selectByIndex(1);
		sel.selectByValue("i");
		sel.selectByVisibleText("idly");
		//getting all selected options list
		List<WebElement> seloptions = sel.getAllSelectedOptions();
		int selected_count=seloptions.size();
		System.out.println("The count of selected options is :" +selected_count);
		System.out.println("The SelectedtextOptions in reverse are : ");
		for(int i=selected_count-1;i>=0;i--)
		{
			String Text=options.get(i).getText();
			System.out.println(Text);
		}

	}

	// To print the options in ascending order using ArrayList
	@Test
	public void checkPrintOptionsArrayListasc()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/dropdowndemo.html");
		WebElement ele= driver.findElement(By.xpath("//select[@id='Iyengar']"));
		Select sel=new Select(ele);
		List<WebElement> options = sel.getOptions();
		ArrayList<String> list=new ArrayList<String>();
		for(WebElement we:options)
		{
			String Text=we.getText();
			list.add(Text);
		}
		Collections.sort(list);
		System.out.println("In ascending order using ArrayList");
		for(String s:list)
		{

			System.out.println(s);
		}

	}

	// To print the options in descending order using ArrayList
	@Test
	public void checkPrintOptionsArrayListdesc()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/dropdowndemo.html");
		WebElement ele= driver.findElement(By.xpath("//select[@id='Iyengar']"));
		Select sel=new Select(ele);
		List<WebElement> options = sel.getOptions();
		ArrayList<String> list=new ArrayList<String>();
		for(WebElement we:options)
		{
			String Text=we.getText();
			list.add(Text);
		}
		Collections.sort(list,Collections.reverseOrder());
		System.out.println("In descending order using ArrayList");
		for(String s:list)
		{

			System.out.println(s);
		}

	}

	// To print the options in ascending order using TreeSet
	@Test
	public void checkPrintOptionsTreeSetasc()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/dropdowndemo.html");
		WebElement ele= driver.findElement(By.xpath("//select[@id='Iyengar']"));
		Select sel=new Select(ele);
		List<WebElement> options = sel.getOptions();
		TreeSet<String> list=new TreeSet<String>();
		for(WebElement we:options)
		{
			String Text=we.getText();
			list.add(Text);
		}
		System.out.println("In ascending order using TreeSet");
		for(String s:list)
		{

			System.out.println(s);
		}

	}

	// To print the options in descending order using TreeSet
	@Test
	public void checkPrintOptionsTreeSetdesc()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/dropdowndemo.html");
		WebElement ele= driver.findElement(By.xpath("//select[@id='Iyengar']"));
		Select sel=new Select(ele);
		List<WebElement> options = sel.getOptions();
		TreeSet<String> list=new TreeSet<String>(Collections.reverseOrder());
		for(WebElement we:options)
		{
			String Text=we.getText();
			list.add(Text);
		}
		System.out.println("In descending order using TreeSet");
		for(String s:list)
		{

			System.out.println(s);
		}

	}

	// Handling Frames: Switch to frames
	@Test
	public void checkSwitchToFramesUsingIndex()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/Page1.html");
		driver.findElement(By.xpath("//input[@id='t1']")).sendKeys("Karthick");
		//switch to frame: By index
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='t2']")).sendKeys("KarthickJaipal");
		//switch to Main Page
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@id='t1']")).sendKeys("Jaipal");
	}

	@Test
	public void checkSwitchToFramesUsingId()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/Page1.html");
		driver.findElement(By.xpath("//input[@id='t1']")).sendKeys("Karthick");
		//switch to frame : By passing the id of the frame
		driver.switchTo().frame("f1");
		driver.findElement(By.xpath("//input[@id='t2']")).sendKeys("KarthickJaipal");
		//switch to Main Page
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@id='t1']")).sendKeys("Jaipal");
	}

	@Test
	public void checkSwitchToFramesUsingWebElement()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/Page1.html");
		driver.findElement(By.xpath("//input[@id='t1']")).sendKeys("Karthick");
		//switch to frame : By passing the Frame WebElement
		WebElement ele=driver.findElement(By.xpath("//iframe[@id='f1']"));
		driver.switchTo().frame(ele);
		driver.findElement(By.xpath("//input[@id='t2']")).sendKeys("KarthickJaipal");
		//switch to Main Page
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@id='t1']")).sendKeys("Jaipal");
	}

	@Test
	public void checkSwitchToSecondFramesUsingWebElement()
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/Page1.html");
		driver.findElement(By.xpath("//input[@id='t1']")).sendKeys("Karthick");
		//switch to frame : By passing the 1st Frame WebElement
		WebElement ele=driver.findElement(By.xpath("//iframe[@id='f1']"));
		driver.switchTo().frame(ele);
		driver.findElement(By.xpath("//input[@id='t2']")).sendKeys("KarthickJaipal");
		//switch b/w frame : By passing the 2nd Frame WebElement
		WebElement ele1=driver.findElement(By.xpath("//iframe[@id='f2']"));
		driver.switchTo().frame(ele1);
		driver.findElement(By.xpath("//input[@id='t3']")).sendKeys("KarthickJaipal");
		//switch to Main Page
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@id='t1']")).sendKeys("Jaipal");
	}

	//JavaScriptExecutor
	//To pass and clear the data in an disabled element
	@Test
	public void checkActionsOnDisabledElements() throws InterruptedException
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/Page3.html");
		driver.findElement(By.xpath("//input[@id='t3']"));
		//TypeCasting to access js methods
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//To pass values without sendkeys/keys function
		js.executeScript("document.getElementById('t3').value='xyz'");
		Thread.sleep(5000);
		//To clear the values without clear method/Keys function
		js.executeScript("document.getElementById('t3').value=''");

	}

	//To Perform scrollbar actions in both x axis and y axis
	@Test
	public void checkScrollBarActions() throws InterruptedException
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/Page3.html");
		//TypeCasting to access js methods
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//To scrolldown with some value
		for(int i=0;i<3;i++)
		{
			js.executeScript("window.scrollBy(0,10)");
			Thread.sleep(2000);
		}
		//To scrollUp with some value
		for(int i=0;i<3;i++)
		{
			js.executeScript("window.scrollBy(10,0)");
			Thread.sleep(2000);
		}

	}


	//To Perform scrollbar actions on specific element
	@Test
	public void checkScrollBarActionsOnSpecificElement() throws InterruptedException
	{
		driver.get("file:///C:/Users/karthick_jaipal/Desktop/Page3.html");
		WebElement ele=driver.findElement(By.xpath("//input[@id='t3']"));
		Point loc=ele.getLocation();
		int x=loc.getX();
		System.out.println(x);
		int y=loc.getY();
		System.out.println(y);
		//TypeCasting to access js methods
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
		js.executeScript("document.getElementById('t3').value='Karthick'");
	}

	@Test
	public void checkHandlingPopUpByAutoIT() throws IOException
	{
		driver.get("https://selenium.dev/downloads/");
		WebElement ele=driver.findElement(By.xpath("//a[.='3.141.59']"));
		ele.click();
		//path of the executable file generated from AutoIT
		Runtime.getRuntime().exec("C:\\desktop\\download.exe");
	}

	@Test
	public void ReadExcel()
	{
		try {
			File file=new File("./Excel/Testdata.xlsx");

			FileInputStream fis= new FileInputStream(file);
			HSSFWorkbook wb= new HSSFWorkbook(fis);
			HSSFSheet sheet = wb.getSheet("Sheet1");
			HSSFRow row = sheet.getRow(0);
			HSSFCell cell = row.getCell(0);
			/*Workbook wb = WorkbookFactory.create(fis);
						Sheet sh=wb.getSheet();
						Row row=sh.getRow(0);
						Cell cell=row.getCell(0);*/
			String value=cell.getStringCellValue();
			System.out.println(value);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// Synchronization

	@Test
	public void implicitWait()
	{

		//Absrtact Enum : TimeUint
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://foodrx.3tandai.com/login");
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@placeholder='email address']")))).sendKeys("bala@digbihealth.com");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@placeholder='password']")))).sendKeys("bala123");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[.='submit']"))).click();
		wait.until(ExpectedConditions.titleContains("FoodRx"));
		String title=driver.getTitle();
		System.out.println(title);
	}



	@Test
	public void mouseOverAction()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		WebElement ele=driver.findElement(By.xpath("//span[.='Hello, Sign in']"));
		ele.click();
		/*Actions action = new Actions(driver);
		action.moveToElement(ele);*/
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[.='Sign in']")))).click();
	}

	@Test
	public void dragAnddrop()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		WebElement source=driver.findElement(By.xpath(""));
		WebElement target=driver.findElement(By.xpath(""));
		Actions action=new Actions(driver);
		action.dragAndDrop(source, target);
	}
	
	//Google Work
	@Test
	public void checkWait()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q"))).sendKeys("CitiusTech");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='btnK']"))).click();
	}
}

/*@AfterMethod
				public void tearDown()
				{
					driver.quit();
				}*/









