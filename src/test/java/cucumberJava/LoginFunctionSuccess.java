/**
 * 
 */
package cucumberJava;

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
   
   @Then("^I can click on submit button$") 
   public void loginButton() { 
      if(driver.findElement(By.id("submit")).isEnabled()) { 
         System.out.println("Test 1 Pass"); 
      } else { 
         System.out.println("Test 1 Fail"); 
      } 
      driver.close(); 
   } 
	
   @Then("^Login should succeed$") 
   public void checkSuccess() {  
      if(driver.getCurrentUrl().equalsIgnoreCase(
         "http://localhost:8080/PatientAppointmentPage/login.jsp")){ 
            System.out.println("Test login Pass"); 
      } else { 
         System.out.println("Test login Failed"); 
      } 
      driver.close(); 
   }
   
   @Then("^Patient Appointment Form should come up$") 
   public void goToPatientAppointmentForm() { 
      if(driver.getCurrentUrl().equalsIgnoreCase(
         "http://localhost:8080/PatientAppointmentPage/display_appointment_details.jsp")){ 
            System.out.println("Test2 Pass"); 
      } else { 
         System.out.println("Test2 Failed"); 
      } 
      driver.close(); 
   }

}
