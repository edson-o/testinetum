package runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@WEBcompraUnProducto",
        dryRun = false,
        monochrome = true
)
public class Runner {

}
