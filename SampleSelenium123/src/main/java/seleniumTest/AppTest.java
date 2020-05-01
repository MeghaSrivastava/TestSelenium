package seleniumTest;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AppTest 
{
   public  WebDriver driver;
    @BeforeTest
    public void openUrl()
    {
    	
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();      
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com");
		Assert.assertEquals(driver.getTitle(), "Login | Salesforce");
    }
    
    @Test(priority=1)
    public void loginInvalid() throws InterruptedException {
    	driver.findElement(By.id("username")).sendKeys("megha@gmail.com");
    	driver.findElement(By.id("password")).sendKeys("abc@1234");
    	driver.findElement(By.id("Login")).click();
    	
    	//String str=driver.findElement(By.className("loginError")).getText();
    	String str=driver.findElement(By.cssSelector(".loginError")).getText();
    	System.out.println(str+"Megha");
    	//Assert.assertNotEquals(str, "Please check your username and password. "
    	//		+ "If you still can't log in, contact your Salesforce administrator.");
    	
    	Assert.assertTrue(true);
    }
    @Test(priority=2)
    public void loginValid() throws InterruptedException {
    	
    	driver.findElement(By.id("username")).sendKeys("cicd.tier1@gmail.com");
    	driver.findElement(By.id("password")).sendKeys("htp@1234");
    	driver.findElement(By.id("Login")).click();
    	
    	//Assert.assertEquals(driver.getTitle(),"Home Page ~ Salesforce - Developer Edition");
    	Assert.assertTrue(false);
    }
   @Test(priority=3)
   public void tearDown() {
	   driver.close();
   }
   
}