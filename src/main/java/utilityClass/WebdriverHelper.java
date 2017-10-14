package utilityClass;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

import pageObjects.BaseClass;
import utilityClass.BrowserUtils;
import utilityClass.Constant;
import utilityClass.Log;

@SuppressWarnings("unused")
public class WebdriverHelper extends BaseClass{

	public WebdriverHelper(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static String sTestCaseName;


	public static void Setup(String Browser) throws Exception {

		/*DOMConfigurator.configure("log4j2.xml");*/

		System.out.println("BROWSER: " + Browser);
		sTestCaseName = "DVLA Test";

		// Start printing the logs and printing the Test Case name
		Log.startTestCase(sTestCaseName);

		// Launching the browser, from TestNG XML
		driver = BrowserUtils.OpenBrowser(Browser);

		new BaseClass(driver);
	}



	public static void tearDown() {
		// Printing logs to end the test case
		Log.endTestCase(sTestCaseName);
		// Closing the opened driver
		driver.close();
	}


}
