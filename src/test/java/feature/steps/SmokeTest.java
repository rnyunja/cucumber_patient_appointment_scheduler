/**
 * 
 */
package feature.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberJava.DefineWebDriver;

/**
 * @author Rogers Nyunja
 *
 */
public class SmokeTest {

	/**
	 * Initialize the object that provides a webDriver depending on browser type
	 */
	DefineWebDriver definedWebDriver = new DefineWebDriver();

	@Given("^That I open '(.+)' browser$")
	public void openBrowserLoginPage(String browser) {
		definedWebDriver.openBrowser(browser);
	}

	@When("^I enter the landing page URL, '(.+)'$")
	public void goToPatientAppointment(String landingPage) {
		definedWebDriver.getDriver().navigate().to(landingPage);
	}

	@Then("^Login page '(.+)' should come up$")
	public void indexPage(String loginPage) {
		definedWebDriver.getDriver().navigate().to(loginPage);
	}
	
	@When("^I input a valid username, '(.+)'$")
	public void enterUsername(String uName) {
		webDriverWait(uName, "usernameId");
	}

	@And("^I input a valid password, '(.+)'$")
	public void enterPassword(String pwd) {
		webDriverWait(pwd, "passwordId");
	}

	@And("^Login button is enabled$")
	public void submitButton() {
		WebDriverWait wait = new WebDriverWait(definedWebDriver.getDriver(), 4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("submit"))));

		if (definedWebDriver.getDriver().findElement(By.id("submit")).isEnabled()) {
			System.out.println("Test submit button enabled Pass");
		} else {
			System.out.println("Test submit button enabled Fail");
		}
	}
	
	@Then("^I click on the login button$")
	public void clickLoginButton() {
		WebDriverWait wait = new WebDriverWait(definedWebDriver.getDriver(), 4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("submit"))));
		
		definedWebDriver.getDriver().findElement(By.id("submit")).click();
	}

	@And("^Patient Appointment page '(.+)' with a form should come up$")
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