/**
 * 
 */
package cucumberJava;

/**
 * @author Rogers Nyunja
 *
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

public class RunTest {


	@RunWith(Cucumber.class) 
	@CucumberOptions(plugin  = {"html:target/cucumber-htmlreport","json:target/cucumber-report.json"}) 

	public class runTest { }
}
