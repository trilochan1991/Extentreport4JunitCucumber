package iocucumber.base.extension;

import java.util.Date;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Feature;

public class JunitListener extends RunListener{
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	long startTime;
    long endTime;
    String classname = null;
    int i = 0;
 
    @Override
    public void testRunStarted(Description description) throws Exception {
        //Start time of the tests
        startTime = new Date().getTime();
        //Print the number of tests before the all tests execution.
        System.out.println("Tests started! Number of Test case: " + description.testCount() + "\n");
        extent = ExtentReport.extentRepotSetup();
    }
 
    @Override
    public void testRunFinished(Result result) throws Exception {
        //End time of the tests
        endTime = new Date().getTime();
        //Print the below lines when all tests are finished.
        System.out.println("Tests finished! Number of test case: " + result.getRunCount());
        long elapsedSeconds = (endTime-startTime)/1000;
        System.out.println("Elapsed time of tests execution: " + elapsedSeconds +" seconds");
        extent.flush();
    }
 
    @Override
    public void testStarted(Description description) throws Exception {
        //Write the test name when it is started.
        System.out.println(description.getMethodName() + " test is starting...");  
        String actual = null;
        if(i>0){
        	actual = description.getClassName();
        }
        	
        if(i == 0){
        	classname = description.getClassName();
        	test = extent.createTest(Feature.class, description.getClassName());
        	i++;
        }else if(!classname.equals(actual)){
        	test = extent.createTest(Feature.class, description.getClassName());
        	classname = description.getClassName();
        }
    }
 
    @Override
    public void testFinished(Description description) throws Exception {
        //Write the test name when it is finished.
        System.out.println(description.getMethodName() + " test is finished...\n");        
    }
 
    @Override
    public void testFailure(Failure failure) throws Exception {
        //Write the test name when it is failed.
        System.out.println(failure.getDescription().getMethodName() + " test FAILED!!!");
    }
 
    //O.B: IntelliJ ignored by default. I did not succeed to run this method.
    //If you know any way to accomplish this, please write a comment.
    @Override
    public void testIgnored(Description description) throws Exception {
               
    }

}
