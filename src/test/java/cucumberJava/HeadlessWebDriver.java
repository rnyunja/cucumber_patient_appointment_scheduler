/**
 * 
 */
package cucumberJava;

import org.openqa.selenium.WebDriver;
/**
 * @author Rogers Nyunja
 *
 */
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HeadlessWebDriver {

  static protected WebDriver driver;

  public static void setup() {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setJavascriptEnabled(true); // not really needed: JS enabled by default
    caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "src/test/resources/phantomjs");

    driver = new PhantomJSDriver(caps);
  }
  public static void main(String[] args) {
    HeadlessWebDriver.setup();
    driver.get("https://www.testingexcellence.com");
  }
}
