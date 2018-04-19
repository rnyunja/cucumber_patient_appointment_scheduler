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

public class ResetFunctionSuccess {

	/**
	 * Initialize the object that provides a webDriver depending on browser type
	 */
	DefineWebDriver definedWebDriver = new DefineWebDriver();

	@Given("^That I have opened a '(.+)' browser$")
	public void openBrowserResetLogin(String browser) {
		definedWebDriver.openBrowser(browser);
	}

	@And("^I enter URL for login page, '(.+)'$")
	public void goToLandingPage(String url) {
		definedWebDriver.getDriver().navigate().to(url);
	}

	@When("^I enter any username, '(.+)'$")
	public void enterUsername(String username) {
		webDriverWait(username, "usernameId");
	}

	@And("^I enter any password, '(.+)'$")
	public void enterPassword(String pwd) {
		webDriverWait(pwd, "passwordId");
	}

	@Then("^I click on reset button$")
	public void resetButton() {

		if (definedWebDriver.getDriver().findElement(By.id("reset")).isEnabled()) {
			definedWebDriver.getDriver().findElement(By.id("reset")).click();
			System.out.println("Test reset button Pass");
		} else {
			System.out.println("Test reset button Fail");
		}
	}

	@Then("^All the fields on the form should clear$")
	public void resetInputFields() {
		if (definedWebDriver.getDriver().findElement(By.id("usernameId")).getText().isEmpty()
				&& definedWebDriver.getDriver().findElement(By.id("passwordId")).getText().isEmpty()) {
			System.out.println("Test reset button Pass");
		} else {
			System.out.println("Test reset button Fail");
		}
	}

	@Then("^I stay on login page, '(.+)'$")
	public void stayOnLoginPage(String url) {
		if (definedWebDriver.getDriver().getCurrentUrl().equalsIgnoreCase(url)) {
			System.out.println("Stay on login page...Pass");
		} else {
			System.out.println("Stay on login page...Failed");
		}
	}

	/**
	 * Method allows for Waiting for the element to be loaded Without it
	 * NoSuchElementException is thrown: Unable to locate element
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
