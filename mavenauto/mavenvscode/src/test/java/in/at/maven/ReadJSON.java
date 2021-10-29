package in.at.maven;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class ReadJSON {

    WebDriver driver;
    String url, UserName, Password;
    JSONParser parser = new JSONParser();

    @BeforeTest
    public void setup() throws FileNotFoundException, IOException, ParseException {
        System.setProperty("webdriver.chrome.driver", "Driver Path");

        Object obj = parser.parse(new FileReader("JSON Data File Path"));

        JSONObject jsonObject = (JSONObject) obj;

        url = (String) jsonObject.get("URL");

        UserName = (String) jsonObject.get("UserName");

        Password = (String) jsonObject.get("Password");

        driver = new ChromeDriver();

        driver.get(url);

    }

    @Test
     public void testSearch() throws FileNotFoundException, IOException, ParseException 
    {
     driver.findElement(By.id("uname")).sendKeys(UserName);
     
     driver.findElement(By.id("pass")).sendKeys(Password);
     
     driver.findElement(By.name("Login")).click();
    }