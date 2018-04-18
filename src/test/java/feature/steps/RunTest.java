/**
 * 
 */
package feature.steps;

/**
 * @author Rogers Nyunja
 *
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


	@RunWith(Cucumber.class) 
	@CucumberOptions(plugin  = {"html:target/cucumber-htmlreport","json:target/cucumber-report.json"}) //,tags={"@smokeTest","@LoginFunctionSuccess"}

	public class RunTest { }
