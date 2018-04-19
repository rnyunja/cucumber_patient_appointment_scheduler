/**
 * 
 */
package feature.steps;

/**
 * @author Rogers Nyunja
 *
 */
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberJava.DefineWebDriver;
import static org.junit.Assert.assertEquals;
import junit.framework.*;

public class LoginFunctionSuccess {
	
	/**
	 * Initialize the object that provides a webDriver depending on browser type
	 */
	DefineWebDriver definedWebDriver = new DefineWebDriver();
	
	@Given("^That I open a '(.+)' browser$")
	public void openBrowserLoginFunctionPass(String browser) {
		definedWebDriver.openBrowser(browser);
	}

	@And("^I enter login page '(.+)'$")
	public void goToTheLandingPage(String landingPage) {
		definedWebDriver.getDriver().navigate().to(landingPage);
	}

	@When("^I enter a valid username, '(.+)'$")
	public void enterUsername(String uName) {
		webDriverWait(uName, "usernameId");
	}

	@And("^I enter a valid password, '(.+)'$")
	public void enterPassword(String pwd) {
		webDriverWait(pwd, "passwordId");
	}

	@And("^The login button is enabled$")
	public void submitButton() {
		WebDriverWait wait = new WebDriverWait(definedWebDriver.getDriver(), 4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("submit"))));

		if (definedWebDriver.getDriver().findElement(By.id("submit")).isEnabled()) {
			System.out.println("Test submit button enabled Pass");
			
			//Click the button to login
			definedWebDriver.getDriver().findElement(By.id("submit")).click();
		} else {
			System.out.println("Test submit button enabled Fail");
		}
	}
	
	@Then("^I click on login button$")
	public void clickLoginButton() {
		WebDriverWait wait = new WebDriverWait(definedWebDriver.getDriver(), 4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("submit"))));
		
		definedWebDriver.getDriver().findElement(By.id("submit")).click();
	}

	@And("^Patient Appointment Form '(.+)' should come up$")
	public void goToPatientAppointmentForm(String apptFormURL) {
		new WebDriverWait(definedWebDriver.getDriver(), 3000);
		
		if (definedWebDriver.getDriver().getCurrentUrl().equalsIgnoreCase(apptFormURL)) {
			System.out.println("Test login success Pass! Patient Appointment form is up");
		} else {
			System.out.println("Test login Failed");
		}
		//assertEquals(definedWebDriver.getDriver().getCurrentUrl(), apptFormURL);
	}
	
	/**
	 * Method allows for Waiting for the element to be loaded 
	 * Without it NoSuchElementException is thrown: Unable to locate element 
	 * 
	 * @param element
	 * @param elementId
	 */
	public void webDriverWait(String element, String elementId) {
		try {
			WebDriverWait wait = new WebDriverWait(definedWebDriver.getDriver(), 4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.id(elementId))));
			definedWebDriver.getDriver().findElement(By.id(elementId)).sendKeys(element);
		} catch (NoSuchElementException nse) {
			nse.printStackTrace();
		}
	}

}
