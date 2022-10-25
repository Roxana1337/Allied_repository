package CRA.cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/feature/invalidUserValidPasswordRegistration.feature"}
//        ,
//        plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"}
        ,glue= "CRA.cucumber.stepDefinitions")
public class invalidUserValidPassRunner {

}
