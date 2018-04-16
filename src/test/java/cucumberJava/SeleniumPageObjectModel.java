/**
 * 
 */
package cucumberJava;

/**
 * @author Rogers Nyunja
 *
 */
import org.openqa.selenium.*;

import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.WebElement;
 
public class SeleniumPageObjectModel {
 
        private static WebElement element = null;
 
    public static WebElement txtbx_UserName(WebDriver driver){
 
         element = driver.findElement(By.id("usernameId"));
 
         return element;
 
         }
 
     public static WebElement txtbx_Password(WebDriver driver){
 
         element = driver.findElement(By.id("passwordId"));
 
         return element;
 
         }
 
     public static WebElement btn_LogIn(WebDriver driver){
 
         element = driver.findElement(By.id("submit"));
 
         return element;
 
         }
 
}
