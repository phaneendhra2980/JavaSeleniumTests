package in.at.maven;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGSample {

	public WebDriver driver;
	public String baseUrl = "https://www.google.com/";

	@BeforeTest
	public void setBaseURL() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.id("L2AGLb")).click();
	}

	@DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "Selenium" }, { "Java" }, { "C#" } };
    }

	@DataProvider (name = "data-provider")
	public Object[][] dpMethod (Method m){
		switch (m.getName()) {
		case "Sum": 
			return new Object[][] {{2, 3 , 5}, {5, 7, 9}};
		case "Diff": 
			return new Object[][] {{2, 3, -1}, {5, 7, -2}};
		}
		return null;
		
	}

	@Test
	public void VerifyHomePageTitle() {

		System.out.println("Launching Google Chrome browser");
		String expectedTitle = "Google";
		String originalTitle = driver.getTitle();
		Assert.assertEquals(originalTitle, expectedTitle);
	}

	@Test(dataProvider = "data-provider")
	public void SearchKeyWords(String data) {

		System.out.println("Searching Google");	
		System.out.println("Data is: " + data);	
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(data);
	}

	@Test(dataProvider = "data-provider")
    public void testMethod(String data) {
        System.out.println("Data is: " + data);
    }

	@Test (dataProvider = "data-provideradd")
      public void myTest (int a, int b, int result) {
	     int sum = a + b;
		 System.out.println("First Parameter Data is: " + a);
		 System.out.println("Second Parameter Data is: " + b);
		 System.out.println("Sum Result: " + result);
	     Assert.assertEquals(result, sum);
      }

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Starting Test On Chrome Browser");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
		System.out.println("Finished Test On Chrome Browser");
	}
}