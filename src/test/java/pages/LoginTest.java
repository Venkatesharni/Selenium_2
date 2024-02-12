package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginTest {
	 WebDriver driver;
	    final Logger LOGGER = Logger.getLogger(LoginTest.class.getName());

	    @BeforeClass
	    public void setUp() {
	        // Set up WebDriver
	        System.setProperty("webdriver.chrome.driver", "drivers/windows/chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
}
	    @Test
	    public void testLoginSuccess() {
	        // Testing  login functionality with valid user credentials
	        LOGGER.log(Level.INFO, ".... login page...");
	        driver.get("https://demowebshop.tricentis.com/login");
	        LOGGER.log(Level.INFO, "......Entering valid  username...");
	        driver.findElement(LoginPage.usernameField).sendKeys("username");
	        LOGGER.log(Level.INFO, "....Entering validpassword...");
	        driver.findElement(LoginPage.passwordField).sendKeys("password");
	        LOGGER.log(Level.INFO, "....Clicking on login button...");
	        driver.findElement(LoginPage.loginButton).click();

	        // Add assertions for successful login after entering valid user credentials
	        LOGGER.log(Level.INFO, "..Logged in successfully....");
	    }

	    @AfterClass
	    public void tearDown() {
	        // Quit WebDriver
	        LOGGER.log(Level.INFO, "....Closing WebDriver...");
	        driver.quit();
	    }
	}