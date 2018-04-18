/**
 * 
 */
package feature.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When; 

public class LoginPageUp { 
   WebDriver driver = null; 
	
   @Given("^I open a chrome browser$") 
   public void openBrowser() { 
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\ncr_r\\GeckoDriver\\geckodriver.exe");
      driver = new FirefoxDriver();
      driver.get("http://seleniumhq.com");
   } 
	
   @When("^I enter http://localhost:8080/PatientAppointmentPage$") 
   public void goToPatientAppointment() { 
      driver.navigate().to("http://localhost:8080/PatientAppointmentPage/"); 
   } 
	
   @Then("^The login page http://localhost:8080/PatientAppointmentPage/login.jsp should come up$") 
   public void indexPage() { 
	   driver.navigate().to("http://localhost:8080/PatientAppointmentPage/login.jsp"); 
   }
}
