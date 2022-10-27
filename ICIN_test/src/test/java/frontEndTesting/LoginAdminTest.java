package frontEndTesting;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginAdminTest {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Mphasis\\chromedriver.exe");
		driver =  new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
		driver.get("http://localhost:4201/login");
	}
	
	@Test(priority = 1)
	public  void loginUser() throws InterruptedException {
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("admin");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(1000L);
		assertEquals(driver.getCurrentUrl(), "http://localhost:4201/login");

	}
//	@Test(priority = 2)
//	public  void loginAdmin() throws InterruptedException {
//		driver.get("http://localhost:4201/login");
//		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("admin");
//		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin");
//		driver.findElement(By.id("loginButton")).click();
//		Thread.sleep(1000L);
//		assertEquals(driver.getCurrentUrl(), "http://localhost:4201/login");
//
//	}
//	
	@AfterTest
	public void cleanUp() {
		driver.close();
	}

}
