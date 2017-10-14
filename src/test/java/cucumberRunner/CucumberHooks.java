package cucumberRunner;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilityClass.WebdriverHelper;

@CucumberOptions(features = "target/test-classes", tags = {"@sanity"}, monochrome = true, plugin = 
	{
		"pretty","html:target/cucumber-report",
	    "json:target/cucumber-report/cucumber.json",
		"rerun:target/cucumber-report/rerun.txt"
	    
	},
	glue = "pageSteps"
)

public class CucumberHooks extends AbstractTestNGCucumberTests {
	
	 @Parameters({"Browser"})
	 @BeforeTest
	 public static void init(String Browser) throws Exception {
		 
		 WebdriverHelper.Setup(Browser);
		 
	 }
	 
	@AfterTest
	    public static void end() throws Exception {
		 WebdriverHelper.tearDown();
		 
	 }
	
	

}


