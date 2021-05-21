package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features"},
        glue = {"Steps"},
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
        		 "junit:target/cucumber-reports/Cucumber.xml",
        		 "html:target/cucumber-reports/Cucumber.html"},
        monochrome = true)

public class Runner {

}
