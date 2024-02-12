package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

	public static By usernameField = By.id("Email");;
	public static By passwordField  = By.id("Password");;
	public static By loginButton = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input");;
	 public static By remember = By.id("RememberMe");
	
}
