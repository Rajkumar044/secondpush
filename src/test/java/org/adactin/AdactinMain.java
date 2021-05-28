package org.adactin;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AdactinMain extends Base111{
	public static WebDriver driver;
	@BeforeClass
	public static void beforeClass() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Deva\\Desktop\\eclipse\\JunitSample\\driver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://adactinhotelapp.com/index.php");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("done");
	driver.close();
	}
	@Before
	public void before() {
	Date date=new Date();
	System.out.println(date);
	}
	@After
	public void after() throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshotAs, new File("adactinn.png"));
	Date date=new Date();
	System.out.println(date);
	}
	@Test
	public void tc0() throws IOException {
		WebElement userName = driver.findElement(By.id("username"));
		textBox(userName,getValueFromExcel("C:\\Users\\Deva\\Desktop\\eclipse\\Adxl\\Excel\\adactin.xlsx", "sheet1", 0, 0));
		WebElement userPassword = driver.findElement(By.id("password"));
		textBox(userPassword,getValueFromExcel("C:\\Users\\Deva\\Desktop\\eclipse\\Adxl\\Excel\\adactin.xlsx", "sheet1", 0, 1));
		WebElement clkLogin = driver.findElement(By.id("login"));
		btnClick(clkLogin);
	}
	
	@Test
	public void tc1() throws IOException {
		
		Base111 base=new Base111();
		WebElement location = driver.findElement(By.xpath("//select[@id='location']"));
		base.dropDown(location, 1);
		
		WebElement hotel = driver.findElement(By.id("hotels"));
		base.dropDown(hotel, 1);
		
		WebElement roomType = driver.findElement(By.id("room_type"));
		base.dropDown(roomType, 1);
		
		WebElement noOfRooms = driver.findElement(By.id("room_nos"));
		base.dropDown(noOfRooms, 1);
		
		WebElement dateCheckIn = driver.findElement(By.id("datepick_in"));
		textBox(dateCheckIn, getValueFromExcel("C:\\Users\\Deva\\Desktop\\eclipse\\Adxl\\Excel\\adactin.xlsx", "sheet1", 1, 0));
	
		WebElement dateCheckOut = driver.findElement(By.id("datepick_out"));
		textBox(dateCheckOut, getValueFromExcel("C:\\Users\\Deva\\Desktop\\eclipse\\Adxl\\Excel\\adactin.xlsx", "sheet1", 1, 1));
	
		WebElement adultsNo = driver.findElement(By.id("adult_room"));
		base.dropDown(adultsNo, 1);
	
		WebElement childNo = driver.findElement(By.id("child_room"));
		base.dropDown(childNo, 1);
		
		WebElement clkSubmit = driver.findElement(By.id("Submit"));
		btnClick(clkSubmit);
		}
	@Test
	public void tc2() {
		WebElement clkRadioButton = driver.findElement(By.id("radiobutton_0"));
		btnClick(clkRadioButton);
		
		WebElement clkContinueButton = driver.findElement(By.id("continue"));
		btnClick(clkContinueButton);
	}
	@Test
	public void tc3() throws IOException {
		Base111 base=new Base111();
		WebElement firstName = driver.findElement(By.id("first_name"));
		textBox(firstName, getValueFromExcel("C:\\Users\\Deva\\Desktop\\eclipse\\Adxl\\Excel\\adactin.xlsx", "sheet1", 2, 0));
		
		WebElement lastName = driver.findElement(By.id("last_name"));
		textBox(lastName, getValueFromExcel("C:\\Users\\Deva\\Desktop\\eclipse\\Adxl\\Excel\\adactin.xlsx", "sheet1", 2, 1));
		
		WebElement adress = driver.findElement(By.id("address"));
		textBox(adress, getValueFromExcel("C:\\Users\\Deva\\Desktop\\eclipse\\Adxl\\Excel\\adactin.xlsx", "sheet1", 3, 0));
		
		WebElement creditNo = driver.findElement(By.id("cc_num"));
		textBox(creditNo, getValueFromExcel("C:\\Users\\Deva\\Desktop\\eclipse\\Adxl\\Excel\\adactin.xlsx", "sheet1", 3, 1));
		
		WebElement creditType = driver.findElement(By.id("cc_type"));
		base.dropDown(creditType, 3);
		
		WebElement expMonth = driver.findElement(By.id("cc_exp_month"));
		base.dropDown(expMonth, 3);
		
		WebElement expYear= driver.findElement(By.id("cc_exp_year"));
		base.dropDown(expYear, 12);
		
		WebElement ccvNo = driver.findElement(By.id("cc_cvv"));
		textBox(ccvNo, getValueFromExcel("C:\\Users\\Deva\\Desktop\\eclipse\\Adxl\\Excel\\adactin.xlsx", "sheet1", 4, 0));
		
		WebElement clkbookNow = driver.findElement(By.id("book_now"));
		btnClick(clkbookNow);
		
		

	}
	
	
	
	
	
	
	
	
	
	
}



