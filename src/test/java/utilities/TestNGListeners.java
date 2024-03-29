package utilities;

import java.io.File;
import java.io.IOException;

import javax.swing.text.Utilities;
import org.testng.Assert;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners(utilities.MyListeners.class)


public class TestNGListeners <TakeScreenshot> {
	
	static WebDriver driver;
	String siteUrl="https://demowebshop.tricentis.com/login";
	@BeforeMethod
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(siteUrl);
	}
	
	@Test
	public void LoginFailTest() {
		driver.findElement(By.id("Email")).sendKeys("abcd@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("abcd125");
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();
		
		String expectedUrl = "Demo Web Shop. Login";
		String actualUrl =  driver.getTitle();
		System.out.println(actualUrl);
		Assert.assertNotEquals(actualUrl, expectedUrl);
		
		
	}
	
	public  void captureScreenshot(String testName) {
		
		TakesScreenshot takesscreenshot = (TakesScreenshot) driver;
		File file = takesscreenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("./Screenshots/"+testName+".png");
		
		try {
			FileUtils.copyFile(file, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
