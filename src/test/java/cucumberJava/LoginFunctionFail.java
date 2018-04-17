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

public class LoginFunctionFail { 
   WebDriver driver = null; 
	
   @Given("^I enter the correct Url$") 
   public void goToPatientAppointment() { 
      driver.navigate().to("http://localhost:8080/PatientAppointmentPage/"); 
   } 
	
   @And("^I enter username$") 
   public void enterUsername(String arg1) {   
      driver.findElement(By.id("usernameId")).sendKeys(arg1); 
   }
	
   @When ("^Enter an invalid password$") 
   public void enterPassword(String arg1) {
      driver.findElement(By.id("passwordId")).sendKeys(arg1);
      driver.findElement(By.id("passwordId")).click(); 
   } 
   
   @Then("^I can click on submit button$") 
   public void loginButtonEnabled() { 
      if(driver.findElement(By.id("submit")).isEnabled()) { 
         System.out.println("Test button enabled Pass"); 
      } else { 
         System.out.println("Test button enabled Fail"); 
      } 
      driver.close(); 
   } 

   @Then("^Login should fail$") 
   public void checkFail() {  
      if(driver.getCurrentUrl().equalsIgnoreCase(
         "http://localhost:8080/PatientAppointmentPage")){ 
            System.out.println("Test login with invalid credentials Pass"); 
      } else { 
         System.out.println("Test1 login with invalid credentials Fail"); 
      } 
      driver.close(); 
   }
   
   @Then("^Relogin option should be available$") 
   public void checkRelogin() { 
      if(driver.getCurrentUrl().equalsIgnoreCase(
         "http://localhost:8080/PatientAppointmentPage")){ 
            System.out.println("Test relogin available Pass"); 
      } else { 
         System.out.println("Test relogin available Fail"); 
      } 
      driver.close(); 
   }

}
