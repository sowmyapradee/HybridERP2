package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import applicationLayer.AdminLogin;
import applicationLayer.AdminLogout;

public class Base {

	WebDriver driver;
	Properties conpro;
	@BeforeTest
	public  void setup() throws IOException {
		conpro = new Properties();
		conpro.load(new FileInputStream("C:\\Users\\tanvi\\OneDrive\\Desktop\\Java practice\\NewEclipse\\DataDriven_FrameWork\\PropertyFiles\\locator.properties"));
		driver = new ChromeDriver();
		driver.get(conpro.getProperty("weblink"));
		AdminLogin login = PageFactory.initElements(driver, AdminLogin.class);
		login.adminlogin("Admin", "Qedge123!@#");
	}
	@AfterTest
	public void logout() throws InterruptedException {
		AdminLogout logout = PageFactory.initElements(driver, AdminLogout.class);
		logout.logout();
		driver.quit();
	}
}
