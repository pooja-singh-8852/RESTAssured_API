package testRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		glue = "stepDefinition",
		monochrome = true,
		plugin="json:target/jsonReport/cucumber-report.json",
		tags="@Deleteplace"
		)
public class runTest {
// compile test verify
}
