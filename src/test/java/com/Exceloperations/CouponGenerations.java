package ExcelOperations;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class CouponGenerations
{

	public static WebDriver driver;
	public static WebDriverWait w1;
	@BeforeTest
	public void openBrowser() 
	{
	System.setProperty("webdriver.chrome.driver","/home/acer/Documents/driver/chromedriver" );
	driver=new ChromeDriver();
	}

	@BeforeClass
	public void logins() throws InterruptedException
	{
	driver.get("https://shriramuat.bizgaze.com/");
	Thread.sleep(3000);
	driver.findElement(By.id("InputEmail")).sendKeys("sp@bizgaze.com");
	driver.findElement(By.id("InputPassword")).sendKeys("123456");
	driver.findElement(By.id("BtnLogin")).click();
	}
	@AfterClass(enabled=false)
	public void closeBrowser()
	{
	driver.close();
	}
	@AfterTest(enabled=false)
	public void logout()
	{

	}
	@BeforeMethod
	public void handleWindowPopup() throws AWTException,InterruptedException
	{
	driver.manage().window().maximize();
	Thread.sleep(3000);
	}
	@Test(priority=1)
	public void sprl1() throws InterruptedException, IOException
	{
	w1=new WebDriverWait(driver,30);
	w1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='nav-button-apps']")));
	driver.findElement(By.xpath("//li[@id='nav-button-apps']")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Coupons")).click();
	w1.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Generate Master code")));
	driver.findElement(By.linkText("Generate Master code")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("btn_CreateGenerateMastercode")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("select2-txtAutoComplete_100021200003484-container")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//li[text()='CA0009A004C1361']")).click();
	driver.findElement(By.id("select2-ddl_cascading_100021200003486-container")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//li[text()='Others']")).click();
	driver.findElement(By.id("txt_100021200003485")).sendKeys("1");
	driver.findElement(By.id("btnSection_100021250000029")).click();

	String excelfilePath="//home//acer//Documents//coupons.xlsx";
	FileInputStream fi= new FileInputStream(excelfilePath);
	//to specify workbooks
	XSSFWorkbook workbook= new XSSFWorkbook(fi);
	//to specify worksheet
	XSSFSheet sheet=workbook.getSheet("coupons");
	int rows=sheet.getLastRowNum();
	int cols=sheet.getRow(0).getLastCellNum()-6;
	for(int r=1;r<=rows&&r<=1;r++)  //	for(int r=1;r<=rows&&r<=3;r++) when it come to row 4 it will stop the priniting
	{
	XSSFRow row=sheet.getRow(r);
	for(int col=2;col>=cols;col--)
	{
	XSSFCell cell= row.getCell(col);
	switch(cell.getCellType())
	{
	case STRING: String myval=cell.getStringCellValue();
    driver.findElement(By.id("scan_100021200003626")).sendKeys(myval+Keys.TAB);
    //w1.until(ExpectedConditions.elementToBeClickable(By.id("btnDynamicSave")));
    w1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Save']")));
	driver.findElement(By.xpath("//button[text()='Save']")).click();
    break;
	case NUMERIC: int myval1=(int) cell.getNumericCellValue();
    driver.findElement(By.id("scan_100021200003626")).sendKeys(myval1+" "+Keys.TAB);
	driver.findElement(By.id("btnDynamicSave")).click();
	break;
	case BOOLEAN:boolean myval2=cell.getBooleanCellValue();
	}
	}
	}
	}
}
	
	
	






