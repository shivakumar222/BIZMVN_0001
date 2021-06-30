package MavenDemo.BizgazeMaven;
import java.io.File;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.utility.ReadConfig;

public class SetupClass
{
	ReadConfig rcf=new ReadConfig();
	public String mainurl=rcf.getApplicationURL();
	public String username=rcf.getUsername();
	public String password=rcf.getpassword();
	public static WebDriver driver;
	public static  WebDriverWait w1;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent ;
	Logger log = Logger.getLogger(SetupClass.class);
	@BeforeSuite
	public void extentReport()//extent report 
	{
		htmlReporter = new ExtentHtmlReporter("extent.html");
		htmlReporter.config().setDocumentTitle("Automation report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter); 
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("OS", "windows10");
		extent.setSystemInfo("Tester name", "shiva kumar");
		extent.setSystemInfo("Browser", "Chrome");
		// 2020IN35 udemey coupoun
	}

	@BeforeTest
	public void openBrowser()
	{
		log.info("****************************** Starting chrome browser  *****************************************");
		//System.setProperty("webdriver.chrome.driver",rcf.getChromepath());
		System.setProperty("webdriver.chrome.driver","/home/acer/Documents/driver/chromedriver");
		driver=new ChromeDriver();
		w1=new WebDriverWait(driver,30);
	
	}
	@BeforeClass	
	public void login() throws InterruptedException
	{
		driver.get(mainurl);
		Thread.sleep(3000);
		driver.findElement(By.id("InputEmail")).sendKeys(username);
		driver.findElement(By.id("InputPassword")).sendKeys(password);
		driver.findElement(By.id("BtnLogin")).click();	
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
	}
	@AfterClass(enabled=false)
	public void Logout()
	{
		w1.until(ExpectedConditions.presenceOfElementLocated(By.id("loginUserImg")));
		driver.findElement(By.id("loginUserImg")).click();
		driver.findElement(By.xpath("//span[text()='Log out']")).click();
	}
	@AfterTest(enabled=true)
	public void closeBrowser()
	{
		driver.close();
	}
	@AfterSuite
	public void tearDown()//extent report close
	{
		extent.flush();
	}
	public static  void screenshot() 
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			//FileUtils.copyFile(src,new File("D:\\eclipse workspace\\shiva\\BizgazeMaven\\Screenshot"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/*	SetupClass() throws EncryptedDocumentException, Exception
{
 String browser=ExcelOperations.readData("Sheet1",1,1);
}
@BeforeTest
public void openBrowser(String browser)
{
	if(browser.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",rcf.getChromepath());
		driver=new ChromeDriver();
	}
	else if(browser.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver",rcf.getFirefoxpath());
	    driver=new FirefoxDriver();
	}
	else if(browser.equals("IEpath"))    
	{
		System.setProperty("webdriver.ie.driver",rcf.getIEpath());
		driver=new InternetExplorerDriver();
	}
	else
	{
		System.out.println("invalid browser");
	}
}*/
