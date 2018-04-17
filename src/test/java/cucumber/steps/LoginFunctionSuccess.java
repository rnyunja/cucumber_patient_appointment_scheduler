/**
 * 
 */
package cucumber.steps;

/**
 * @author Rogers Nyunja
 *
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When; 

public class LoginFunctionSuccess { 
   WebDriver driver = null; 
	
   @Given("^I enter the correct Url$") 
   public void goToPatientAppointment() { 
      driver.navigate().to("http://localhost:8080/PatientAppointmentPage/"); 
   } 
	
   @And("^I enter a valid username$") 
   public void enterUsername(String arg1) {   
      driver.findElement(By.id("email")).sendKeys(arg1); 
   }
	
   @When ("^I enter a valid password$") 
   public void enterPassword(String arg1) {
      driver.findElement(By.id("passwordId")).sendKeys(arg1);
      driver.findElement(By.id("passwordId")).click(); 
   }
   
   @Then("^The login button is enabled$") 
   public void submitButton() { 
      if(driver.findElement(By.id("submit")).isEnabled()) { 
         System.out.println("Test submitButton enabled Pass"); 
      } else { 
         System.out.println("Test submitButton enabled Fail"); 
      } 
      driver.close(); 
   } 
	
   @And("^Patient Appointment Form should come up$") 
   public void goToPatientAppointmentForm() { 
      if(driver.getCurrentUrl().equalsIgnoreCase(
         "http://localhost:8080/PatientAppointmentPage/display_appointment_details.jsp")){ 
            System.out.println("Test login success and appoint form loading Pass"); 
      } else { 
         System.out.println("Test login success and appoint form loading Failed"); 
      } 
      driver.close(); 
   }

}
