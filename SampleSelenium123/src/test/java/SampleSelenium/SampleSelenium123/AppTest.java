package SampleSelenium.SampleSelenium123;



import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class AppTest 
{
   public static WebDriver driver;
    @Test
    public void openUrl()
    {
    	
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();      
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("login.salesforce.com");
    }
    
   
   
}
