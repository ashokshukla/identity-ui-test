package utilityClass;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.BaseClass;
public class BrowserUtils extends BaseClass{

	
	private static final long TIMEOUT = 10;
	private static  final String MY_CURRENT_DIRECTORY = System.getProperty("user.dir");
	private static final String CHROME_DRIVER_PATH = MY_CURRENT_DIRECTORY + "\\browser\\chromedriver.exe";
	private static final String GECKO_DRIVER_PATH = MY_CURRENT_DIRECTORY + "\\browser\\geckodriver.exe";
	private static final String URL = "https://www.gov.uk/get-vehicle-information-from-dvla";
	
	public BrowserUtils(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static WebDriver OpenBrowser(String Browser) throws Exception{
		
	
		System.out.println("User Directory: " + System.getProperty("user.dir"));
		
		String sBrowserName;
		
		try{
			
			sBrowserName =Browser;
			
			switch (sBrowserName.toLowerCase()) {
			case ("chrome"):
				startChromeDriver();
			break;
			case ("firefox"):
				startFireFoxDriver();
			break;
			

			default:
				throw new IllegalArgumentException("Provided browser type is not supported");

			}

			Log.info("New driver instantiated");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Log.info("Implicit wait applied on the driver for 10 seconds");

		}catch (Exception e){
			Log.error("Class Browser Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
		}
		return driver;

	}


	private static void startFireFoxDriver()
	{
		System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		

	}
	private static void startChromeDriver(){
		
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches","--disable-extensions");
		options.addArguments("--disable-web-security");
		options.addArguments("--test-type");
		capabilities.setCapability("chrome.verbose", false);

		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-translate");
		options.addArguments("--start-maximized");

		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		
	}





}
