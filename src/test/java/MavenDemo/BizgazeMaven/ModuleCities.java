package MavenDemo.BizgazeMaven;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ModuleCities  extends SetupClass
{
	public ExtentTest test;
	@BeforeMethod()
  public void handleWindowPopup() throws AWTException, InterruptedException
	{
		driver.manage().window().maximize();
		Thread.sleep(3000);
		Robot r1=new Robot();	
		r1.keyPress(KeyEvent.VK_TAB);
		r1.keyPress(KeyEvent.VK_TAB);
		r1.keyPress(KeyEvent.VK_ENTER);	
	}
	@Test(priority=1)
	public void testCreatecity()
			{	
		//GIVING ALL DETAILS AND CLICK ON SAVE 
		test = extent.createTest(" MyFirstTest", "open chrome browser and my url ");
		w1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Cities']")));
		driver.findElement(By.xpath("//div[text()='Cities']")).click();
		driver.findElement(By.id("btnCreateNew")).click();	
		WebElement CityName=w1.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt_CityName")));
		CityName.sendKeys(rcf.getCityName());
        driver.findElement(By.cssSelector("input[id='txt_CityCode']")).sendKeys(rcf.getCityCode());
		driver.findElement(By.id("select2-txtAutoComplete_110144181002819_DistrictId-container")).click();
		WebElement dropdown =w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Agra']")));
		dropdown.click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		/*	w11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='bizgaze_body']/div[8]/div")));
		String s=driver.findElement(By.xpath("//*[@id='bizgaze_body']/div[8]/div")).getText();
		Reporter.log(s);	*/
		log.info("****************************** ending test case *****************************************");
	}

	/*@Test(priority=2)
public void testCreateCity1()      
{
	      //WITHOUT GIVING CITY CODE AND CLICK ON SAVE 

         driver.findElement(By.id("btnCreateNew")).click();
         WebDriverWait w2=new WebDriverWait(driver,3); 
         WebElement CityName=w2.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt_CityName")));
         CityName.sendKeys("town Gunturw");
         driver.findElement(By.id("select2-txtAutoComplete_110144181002819_DistrictId-container")).click();
         WebElement dropdown =w2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Agra']")));
         dropdown.click();
         driver.findElement(By.xpath("//button[text()='Save']")).click();
         String s=driver.findElement(By.id("Bizgaze-messageInfo")).getText();
         Reporter.log(s);
         driver.findElement(By.xpath("//a[text()=' Close']")).click();      	
}
@Test(priority=3)
public void testCreatecity2() throws InterruptedException
{
	//WITHOUT  GIVING CITYNAME AND CLICK ON SAVE 

	 driver.findElement(By.id("btnCreateNew")).click();
	 WebDriverWait w11=new WebDriverWait(driver,30); 
     WebElement Citycode=  w11.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='txt_CityCode']")));
     Citycode.sendKeys("254");
     WebDriverWait w2=new WebDriverWait(driver,3); 
     driver.findElement(By.id("select2-txtAutoComplete_110144181002819_DistrictId-container")).click();
 	 WebElement dropdown =w2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Agra']")));
 	 dropdown.click();
 	 driver.findElement(By.xpath("//button[text()='Save']")).click(); 	
 	 String s1=  driver.findElement(By.id("Bizgaze-messageInfo")).getText();
 	 Reporter.log(s1);
 	 driver.findElement(By.xpath("//a[text()=' Close']")).click();
}
@Test(priority=4)
public void testCreatecity3()
{
   //WITHOUT GIVING DISTRICT NAME DROPDOWN AND CLICK ON SAVE 

	 driver.findElement(By.id("btnCreateNew")).click();
     WebDriverWait w2=new WebDriverWait(driver,3); 
     WebElement CityName=w2.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt_CityName")));
     CityName.sendKeys("town vijawada1");
	 driver.findElement(By.cssSelector("input[id='txt_CityCode']")).sendKeys("2541");
	 driver.findElement(By.xpath("//button[text()='Save']")).click();
	 String s2=driver.findElement(By.id("Bizgaze-messageInfo")).getText();
	 Reporter.log(s2);
	 driver.findElement(By.xpath("//a[text()=' Close']")).click();
}
@Test(priority=5)
public void testCreatecity4()
{
	//WITHOUT GIVING ANY DETAILS AND CLICK ON SAVE 

    driver.findElement(By.id("btnCreateNew")).click();
	WebDriverWait w11=new WebDriverWait(driver,50); 
    WebElement save=  w11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save']")));
    save.click();
    Reporter.log(driver.findElement(By.id("Bizgaze-messageInfo")).getText());
    driver.findElement(By.xpath("//a[text()=' Close']")).click();
}
@Test(priority=6)
public void testCreatecity5()
{	
	//GIVING DUPLICATE CITYNAME

	driver.findElement(By.id("btnCreateNew")).click();
	WebDriverWait w11=new WebDriverWait(driver,30); 
    WebElement CityName=w11.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt_CityName")));
    CityName.sendKeys("town vijawada");
	driver.findElement(By.cssSelector("input[id='txt_CityCode']")).sendKeys("1254");
    WebDriverWait w2=new WebDriverWait(driver,3); 
    driver.findElement(By.id("select2-txtAutoComplete_110144181002819_DistrictId-container")).click();
	WebElement dropdown =w2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Agra']")));
	dropdown.click();
	driver.findElement(By.xpath("//button[text()='Save']")).click();
	w11.until(ExpectedConditions.visibilityOfElementLocated(By.id("Bizgaze-messageInfo")));
	Reporter.log(driver.findElement(By.id("Bizgaze-messageInfo")).getText());
	driver.findElement(By.xpath("//a[text()=' Close']")).click();	
}
@Test(priority=7)
public void testCreatecity6()
{
	//GIVING  DUPLIACTE CITYCODE

	driver.findElement(By.id("btnCreateNew")).click();
	WebDriverWait w11=new WebDriverWait(driver,30); 
    WebElement CityName=w11.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt_CityName")));
    CityName.sendKeys("town gunturer");
	driver.findElement(By.cssSelector("input[id='txt_CityCode']")).sendKeys("254");
    WebDriverWait w2=new WebDriverWait(driver,3); 
    driver.findElement(By.id("select2-txtAutoComplete_110144181002819_DistrictId-container")).click();
	WebElement dropdown =w2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Agra']")));
	dropdown.click();
	driver.findElement(By.xpath("//button[text()='Save']")).click();
	w11.until(ExpectedConditions.visibilityOfElementLocated(By.id("Bizgaze-messageInfo")));
	Reporter.log(driver.findElement(By.id("Bizgaze-messageInfo")).getText()); 
}*/
	@AfterMethod
	public void result(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,"Test Case FAILED IS"+result.getName());//to add name in extent report
			test.log(Status.FAIL,"Test Case FAILED IS"+result.getThrowable());//to add error/exception in extent report	
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "Test case skipped is"+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test case PASSED is"+result.getName());
		}
	}
}


