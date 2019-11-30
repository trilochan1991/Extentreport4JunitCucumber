package iocucumber.amazon.runners;
import io.cucumber.junit.CucumberOptions;
import iocucumber.base.extension.Extendcucumber;

import org.junit.runner.RunWith;

	@RunWith(Extendcucumber.class)
	@CucumberOptions(
			features = "src/test/source/facebookfeatures", //the path of the feature files
			glue={"/iocucumber/base/definition"}, //the path of the step definition files			
			monochrome = true, //display the console output in a proper readable format
			strict = true, //it will check if any step is not defined in step definition file
			dryRun = false, //to check the mapping is proper between feature file and step def file
			tags = "@Excel"			
			)
	
public class GoogleLoginrunner {
		
}
