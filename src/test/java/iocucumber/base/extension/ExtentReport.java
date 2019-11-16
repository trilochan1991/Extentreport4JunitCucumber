package iocucumber.base.extension;

import java.util.Random;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	public static ExtentHtmlReporter report;	
	public static ExtentReports extent;
	public static ExtentTest test; 
		
	
	public static ExtentReports extentRepotSetup(){
		Random rnd = new Random();
		int random = rnd.nextInt(10000000);
		report = new ExtentHtmlReporter("src/test/source/extentreporthtml/report"+random+".html");
		report.config().setDocumentTitle("Trilochan automation test");
		report.config().setReportName("Trilochan automation Report Name");
		report.config().setTheme(Theme.DARK);
		report.start();		
		extent = new ExtentReports();
		extent.attachReporter(report);	
		test = extent.createTest(Feature.class, "Feature facebook");
		return extent;
	}

}
