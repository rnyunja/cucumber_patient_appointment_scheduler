/**
 * 
 */
package cucumberJava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When; 

public class LoginPage { 
   WebDriver driver = null; 
	
   @Given("^I have an open browser$") 
   public void openBrowser() { 
      driver = new ChromeDriver(); 
   } 
	
   @When("^I enter the correct Url$") 
   public void goToPatientAppointment() { 
      driver.navigate().to("http://localhost:8080/PatientAppointmentPage/"); 
   } 
	
   @Then("^The login page should come up$") 
   public void indexPage() { 
	   driver.navigate().to("http://localhost:8080/PatientAppointmentPage/login.jsp"); 
   }
}
