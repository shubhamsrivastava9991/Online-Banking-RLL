package frontEndTesting;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import   frontEndTesting.LoginTest;


public class TransferFundTest {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", 
				"F:\\workspace\\chromedriver.exe");
		driver =  new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
		driver.get("http://localhost:4200/login");
	}
	
	@Test
	public void transferFund() throws InterruptedException  {
		
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("test1234@gmail.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Abc@12345");
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.linkText("Transfer")).click();;
		
		//Filling Up transfer fund form
		driver.findElement(By.id("beneficiaryName")).sendKeys("Shubham");
		driver.findElement(By.id("beneficiaryAccountNumber")).sendKeys("22113345");
		driver.findElement(By.id("beneficiaryIFSCCode")).sendKeys("ICIN00105");
		driver.findElement(By.id("amountToBeTransfered")).sendKeys("100");
		driver.findElement(By.id("description")).sendKeys("Fund Transfer");
		driver.findElement(By.id("tranferFundButton")).click();
		Thread.sleep(2000L);
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		assertEquals(text, "Transaction Successfull");
		driver.navigate().back();
		
		
}
	
	@Test
public void transferFundGreaterThanBalance() throws InterruptedException  {
		
		driver.findElement(By.linkText("Transfer")).click();;
		
		//Filling Up transfer fund form
		driver.findElement(By.id("beneficiaryName")).sendKeys("Shubham");
		driver.findElement(By.id("beneficiaryAccountNumber")).sendKeys("11223345");
		driver.findElement(By.id("beneficiaryIFSCCode")).sendKeys("ICIN00105");
		driver.findElement(By.id("amountToBeTransfered")).sendKeys("10000");
		driver.findElement(By.id("description")).sendKeys("Fund Transfer");
		driver.findElement(By.id("tranferFundButton")).click();
		Thread.sleep(2000L);
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		assertEquals(text, "Insufficient funds");
		driver.navigate().back();
		
		
}
	@Test
public void transferFundWithIncorrectAccountNumber() throws InterruptedException  {
		
		driver.findElement(By.linkText("Transfer")).click();;
		
		//Filling Up transfer fund form
		driver.findElement(By.id("beneficiaryName")).sendKeys("Rahul Jain");
		driver.findElement(By.id("beneficiaryAccountNumber")).sendKeys("11223348");
		driver.findElement(By.id("beneficiaryIFSCCode")).sendKeys("ICIN00105");
		driver.findElement(By.id("amountToBeTransfered")).sendKeys("10");
		driver.findElement(By.id("description")).sendKeys("Fund Transfer");
		driver.findElement(By.id("tranferFundButton")).click();
		Thread.sleep(2000L);
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		//assertEquals(text, "Transaction failed Incorrect benificiary account number");
		driver.navigate().back();
		
		
}
	
	
	@AfterTest
	public void cleanUp() {
		driver.close();
	}
}
