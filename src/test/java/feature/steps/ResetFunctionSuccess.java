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

	@Given("^That I open '(.+)' browser$")
	public void openBrowserLoginFunctionFail(String browser) {
		definedWebDriver.openBrowser(browser);
	}

	@And("^I navigate to login page, '(.+)'$")
	public void goToTheLandingPage(String url) {
		definedWebDriver.getDriver().navigate().to("http://localhost:8080/PatientAppointmentPage/");
	}

	@When("^I enter a username, '(.+)'$")
	public void enterUsername(String username) {
		webDriverWait(username, "email");
	}

	@And("^I enter a password, '(.+)'$")
	public void enterPassword(String pwd) {
		webDriverWait(pwd, "passwordId");
	}

	@Then("^I click on reset button$")
	public void resetButton() {
		
		WebDriverWait wait = new WebDriverWait(definedWebDriver.getDriver(), 4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("reset"))));
		
		definedWebDriver.getDriver().findElement(By.id("reset")).click();
		webDriverWait("password", "passwordId");
		
		if (definedWebDriver.getDriver().findElement(By.id("username")).getText().isEmpty() &&
				definedWebDriver.getDriver().findElement(By.id("password")).getText().isEmpty()) {
			System.out.println("Test reset button Pass");
		} else {
			System.out.println("Test reset button Fail");
		}
		// driver.close();
	}

	@Then("^All the fields should clear on the form$")
	public void resetInputFields() {
		if (definedWebDriver.getDriver().getCurrentUrl()
				.equalsIgnoreCase("http://localhost:8080/PatientAppointmentPage/login.jsp")) {
			System.out.println("Test reset Pass");
		} else {
			System.out.println("Test reset Failed");
		}
		// driver.close();
	}

	@And("^I stay on login page, '(.+)'$")
	public void stayOnLoginPage(String url) {
		if (definedWebDriver.getDriver().getCurrentUrl().equalsIgnoreCase(url)) {
			System.out.println("Stay on login page...Pass");
		} else {
			System.out.println("Stay on login page...Failed");
		}
		// driver.close();
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
