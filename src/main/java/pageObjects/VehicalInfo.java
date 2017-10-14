package pageObjects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilityClass.Constant;
import utilityClass.Log;
import utilityClass.readExcelFile;
import static org.testng.Assert.*;

public class VehicalInfo extends BaseClass{

	private static WebElement element = null;

	private static String mainTitleText = "Where Experiences are Engineered - Valtech";
	private static By assertHomePage = By.xpath("/html/head/title");
	private static By startButton = By.xpath("/html/body/div[5]/div[2]/main/div/div[1]/div/section[1]/p/a");
	
	private static By enterRegNo = By.xpath("/html/body/main/form/div/div/div[2]/fieldset/div/input");
	private static By contButton = By.name("Continue");
			
	public VehicalInfo(WebDriver driver){
		super(driver);
	}

	public static void launchURL(){

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.navigate().to(Constant.URL);
		Log.info("Web application launched successfully");

	}

	public static void assertHomePage() throws Exception{

		
		try{ 
			assertTrue(driver.findElement(assertHomePage).getText().contains("Get vehicle information from DVLA - GOV.UK"));
			Log.info("DVLA home page assert PASS");
		}catch (Exception e){
			Log.error("DVLA home page assert FAIL");
			throw(e);
		}
	}

	public static void enterRegistrationNo() throws Exception{
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		readExcelFile.setExcelFile(Constant.INPUT_DIRECTORY, "Sheet1");
		String sRegistrationNo = readExcelFile.getCellData(1, 1);
		String sVehicleCoolor = readExcelFile.getCellData(1, 2);
		System.out.println("Vehicle Coolor: " + sVehicleCoolor);
		
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		try{ 
			driver.findElement(enterRegNo).sendKeys(sRegistrationNo);
			
			driver.findElement(contButton).click();
			
			Log.info("Enter Registration number PASS");
		}catch (Exception e){
			Log.error("Enter Registration number FAIL");
			throw(e);
		}

	}

	public static void clickStartButton() throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try{ 
			driver.findElement(startButton).click();

			Log.info("Clicked on Start button from DVLA Home Page PASS");
		}catch (Exception e){
			Log.error("Clicked on Start button from DVLA Home Page FAIL");
			throw(e);
		}

		
	}

}
