package CRA.cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature", glue= "CRA/cucumber/stepDefinitions"
//        ,
//        plugin = {"pretty", "html:target/site/cucumber-pretty.html"}
)
public class CucumberReporting {
}
