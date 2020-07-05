package MavenDemo.BizgazeMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class SETUP
{
	public static WebDriver driver;
	@BeforeTest
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		/*System.setProperty("webdriver.gecko.driver","C:\\driver\\geckodriver.exe");
		driver=new FirefoxDriver();*/
	}
   @BeforeClass
   public void login() throws InterruptedException
   {
	
	   driver.get("https://testv3.bizgaze.com/");
	   driver.findElement(By.id("InputEmail")).sendKeys("8500665284");
	   driver.findElement(By.id("InputPassword")).sendKeys("123456");
	   driver.findElement(By.id("BtnLogin")).click();	   
   }
   @AfterClass(enabled=false)
   public void Logout()
   {
	    WebDriverWait w11=new WebDriverWait(driver,50); 
	    w11.until(ExpectedConditions.presenceOfElementLocated(By.id("loginUserImg")));
	       driver.findElement(By.id("loginUserImg")).click();
	        driver.findElement(By.xpath("//span[text()='Log out']")).click();
   }
   @AfterTest(enabled=false)
   public void closeBrowser()
   {
	   driver.close();
   }
}
