/**
 * 
 */
package feature.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberJava.DefineWebDriver;

public class LoginPageUp {
	
	/**
	 * Initialize the object that provides a webDriver depending on browser type
	 */
	DefineWebDriver definedWebDriver = new DefineWebDriver();

	@Given("^I open a '(.+)' browser$")
	public void openBrowserLoginPage(String browser) {
		definedWebDriver.openBrowser(browser);
	}

	@When("^I enter landing page URL, '(.+)'$")
	public void goToPatientAppointment(String landingPage) {
		definedWebDriver.getDriver().navigate().to(landingPage);
	}

	@Then("^The login page '(.+)' should come up$")
	public void indexPage(String loginPage) {
		definedWebDriver.getDriver().navigate().to(loginPage);
	}
	
	public void closeDriver() {
		definedWebDriver.getDriver().close();
	}
}
