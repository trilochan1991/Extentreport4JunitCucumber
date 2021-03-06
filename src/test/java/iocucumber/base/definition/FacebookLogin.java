package iocucumber.base.definition;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import iocucumber.base.extension.ExtentReport;
import iocucumber.base.extension.JunitListener;
import iocucumber.base.filereader.ExcelReader;

import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class FacebookLogin {
	
	public static WebDriver driver;
	public  ExtentReports extent;
	public  ExtentHtmlReporter report;
	public  ExtentTest feature;
	public  ExtentTest scenario;		
	
	@Before()
	public void driverconfiguration(io.cucumber.core.api.Scenario scenariolocal){
		 WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        extent = ExtentReport.extent;	
	        feature = JunitListener.test;	       
	        scenario = feature.createNode(Scenario.class, scenariolocal.getName());
	        driver.get("https://www.facebook.com");
	        driver.manage().window().maximize();
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        
	}	
	
	@After
	public void reardown(){
		driver.quit();
	}
	
	@Given("configure webdriver to be oppened")
	public void configure_webdriver_to_be_oppened() {				        
	        feature = scenario.createNode(com.aventstack.extentreports.gherkin.model.Given.class, "configure webdriver to be oppened paseed");
	        scenario.log(Status.PASS, "configure webdriver to be oppened failed");
	}
	
	@Given("enter username field")
	public void enter_username_field() {
		driver.findElement(By.name("email")).sendKeys(ExcelReader.getTestDatainMap("src/test/source/exceldata/TestData.xlsx", "facebook", "US01").get("UserName"));
	}

	@Given("enter password field")
	public void enter_password_field() {
		driver.findElement(By.name("pass")).sendKeys(ExcelReader.getTestDatainMap("src/test/source/exceldata/TestData.xlsx", "facebook", "US01").get("Password"));
	}
		
 
		
	
	
	
	
	
	

}
