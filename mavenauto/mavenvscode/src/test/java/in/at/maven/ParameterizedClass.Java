import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
public class ParameterizedClass {
WebDriver driver;	
    	@Parameters("keyWord")
    	@Test
    	public void Parameterpassing(String keyWord){	
           	//Initializing Driver
//Mention the path to your local webdriver
           	System.setProperty("webdriver.chrome.driver", "D:\\LocalDriver\\chromedriver.exe");
           	driver = new ChromeDriver();
           	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
           	//Opening search engine
           	driver.get("https://google.com");
    	 	//Finding search text box  
           	 WebElement searchBox = driver.findElement(By.name("q"));
           	 //Sending keyword value
           	 searchBox.sendKeys(keyWord);
           	 System.out.println("The search keyword entered is : " +keyWord);	 
           	 //Verifying the keyword on UI
           	 Assert.assertTrue(searchBox.getAttribute("value").equalsIgnoreCase(keyWord));
           	 driver.quit();
    	}
}