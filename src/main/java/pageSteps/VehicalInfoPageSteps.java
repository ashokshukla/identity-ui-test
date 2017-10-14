package pageSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.VehicalInfo;
import utilityClass.Log;

public class VehicalInfoPageSteps {

	
	@Given("^User navigate to the DVLA Vehicle Information Home Page$")
	public void launchHomePage() throws Throwable {
		Log.info("Launch Home page" );
		VehicalInfo.launchURL();
		
	}
	
	@When("^Verify Home page title$")
	public void verifyHomePageText() throws Throwable {
		
		VehicalInfo.assertHomePage();
		
	}

	@And("^User click on Start button from DVLA Home Page$")
	public void clickStartButton() throws Throwable {
		
		VehicalInfo.clickStartButton();
	}
	
	@Then("^User enter Registration No$")
	public void enterRegNo() throws Throwable {
		
		VehicalInfo.enterRegistrationNo();
	}

}