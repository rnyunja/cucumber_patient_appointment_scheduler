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

public class LoginFunctionFail { 
	
	/**
	 * Initialize the object that provides a webDriver depending on browser type
	 */
	DefineWebDriver definedWebDriver = new DefineWebDriver(); 
	
	@Given("^That I have a '(.+)' browser open$")
	public void openBrowserLoginFunctionFail(String browser) {
		definedWebDriver.openBrowser(browser);
	}
	
   @And("^I enter login URL, '(.+)'$") 
   public void enterURLForLogin(String landingPage) {
	   definedWebDriver.getDriver().navigate().to(landingPage);
   } 
	
   @And("^I enter username that is invalid, like '(.+)'$") 
   public void enterUsername(String userName) { 
	   webDriverWait(userName, "passwordId"); 
	   definedWebDriver.getDriver().findElement(By.id("usernameId")).sendKeys(userName); 
   }
	
   @When ("^I enter an invalid password, like '(.+)'$") 
   public void enterPassword(String pwd) {
	  webDriverWait(pwd, "passwordId"); 
      definedWebDriver.getDriver().findElement(By.id("passwordId")).click(); 
   } 
   
   @Then("^The login button should be enabled$") 
   public void loginButtonEnabled() {
	   WebDriverWait wait = new WebDriverWait(definedWebDriver.getDriver(), 4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("submit")))); 
	   
      if(definedWebDriver.getDriver().findElement(By.id("submit")).isEnabled()) { 
         System.out.println("Test button enabled Pass"); 
      } else { 
         System.out.println("Test button enabled Fail"); 
      } 
//      driver.close(); 
   } 

   @And("^Login should fail$") 
   public void checkFail() {  
      if(definedWebDriver.getDriver().getCurrentUrl().equalsIgnoreCase(
         "http://localhost:8080/PatientAppointmentPage/login.jsp")){ 
            System.out.println("Test login did not work with invalid credentials...It's a Pass"); 
      } else { 
         System.out.println("Test1 login worked with invalid credentials...It's a Fail"); 
      } 
   }
   
   @Then("^Relogin option should be available$") 
   public void checkRelogin() { 
      if(definedWebDriver.getDriver().getCurrentUrl().equalsIgnoreCase(
         "http://localhost:8080/PatientAppointmentPage/login.jsp")){ 
            System.out.println("Test relogin available Pass"); 
      } else { 
         System.out.println("Test relogin available Fail"); 
      } 
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
